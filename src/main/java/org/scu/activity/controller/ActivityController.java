package org.scu.activity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.scu.activity.conf.ActivityStatus;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.vo.VActivity;
import org.scu.base.conf.ResponseMsg;
import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.activity.service.ActivityService;
import org.scu.activity.vo.QActivity;
import org.scu.student.entity.Student;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.scu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2019/1/21
 */
@RestController
@Api(description = "活动", tags = {"活动"})
public class ActivityController extends BaseController {

  @Autowired
  private ActivityService activityService;

  @Autowired
  private UserService userService;

  /**
   * 学生获取活动
   */
  @ApiOperation(value = "学生获取活动信息列表", notes = "学生获取活动信息列表", httpMethod = "GET")
  @GetMapping(value = "/activity")
  public BaseResponse listActivities(HttpServletRequest request,
      @RequestParam(required = false, defaultValue = "false") String self,
      @RequestParam(required = false) Integer type,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    User loginUser = getLoginUser(request);
    if (!loginUser.getRole().equals(UserRole.STUDENT.getCode())) {
      return FORBIDDEN;
    }
    QActivity search = new QActivity();
    if (new Boolean(self)) {
      RoleInfo roleInfo = userService.getRoleInfo(loginUser);
      Student student = (Student) roleInfo;
      search.setStudentId(student.getId());
    }
    search.setMemberActivity(type);
    search.setPage(page);
    search.setPageSize(pageSize);
    List<VActivity> activities = activityService.listActivities(search, ActivityType.All.getCode());
    return response(activities);
  }

  /**
   * 获取社团社联活动列表
   */
  @ApiOperation(value = "获取活动信息列表", notes = "获取活动信息列表{type}为club或union", httpMethod = "GET")
  @GetMapping(value = "/{type}/activity")
  public BaseResponse listClubAndUnionActivities(@PathVariable("type") String type,
      HttpServletRequest request,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) Integer clubId,
      @RequestParam(required = false) Integer commitResult,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    User loginUser = getLoginUser(request);
    QActivity search = new QActivity();
    if (status != null) {
      search.setStatus(status);
    }
    search.setCommitResult(commitResult);//是否提交活动成果
    search.setPage(page);
    search.setPageSize(pageSize);
    List<VActivity> list;
    int totalCount;
    if (type.equalsIgnoreCase(ActivityType.CLUB.getTypeName())) {
      if (loginUser.getRole().equals(UserRole.CLUB_ADMIN.getCode())) {
        search.setUserId(loginUser.getId());
      } else {
        if (clubId != null) {
          search.setClubId(clubId);
        }
      }
      list = activityService.listActivities(search, ActivityType.CLUB.getCode());
      totalCount = activityService.countClubActivities(search);
    } else {
      list = activityService.listActivities(search, ActivityType.UNION.getCode());
      totalCount = activityService.countUnionActivities(search);
    }
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }

  /**
   * 活动申请
   */
  @ApiOperation(value = "活动申请", notes = "申请活动{type}为club或union", httpMethod = "POST")
  @PostMapping("/{type}/activity")
  public BaseResponse applyActivity(@PathVariable("type") String type,
      @RequestBody Activity activity) {
    int result;
    activity.setType(ActivityStatus.UNDER_REVIEW.getCode());
    if (type.equalsIgnoreCase(ActivityType.CLUB.getTypeName())) {
      result = activityService.insert(activity, ActivityType.CLUB.getCode());
    } else {
      result = activityService.insert(activity, ActivityType.UNION.getCode());
    }
    return response(result, activity);
  }

  /**
   * 更改活动状态
   */
  @ApiOperation(value = "活动状态变更", notes = "活动状态变更", httpMethod = "PUT")
  @PutMapping("/activity/{id}/status")
  public BaseResponse publishActivity(@PathVariable("id") Long id,
      @RequestBody QActivity qActivity) {
    Activity activity = activityService.getById(id);
    if (activity != null) {
      if (qActivity.getStatus() == ActivityStatus.PUBLISHED.getCode()
          && activity.getAuditStates() == ActivityStatus.PASS.getCode()) {
        activity.setAuditStates(ActivityStatus.PUBLISHED.getCode());
      } else if (qActivity.getStatus() == ActivityStatus.PASS.getCode()
          && activity.getAuditStates() == ActivityStatus.UNDER_REVIEW.getCode()) {
        activity.setAuditStates(ActivityStatus.PASS.getCode());
      } else if (qActivity.getStatus() == ActivityStatus.NOT_PASS.getCode()
          && activity.getAuditStates() == ActivityStatus.UNDER_REVIEW.getCode()) {
        activity.setAuditStates(ActivityStatus.NOT_PASS.getCode());
      } else {
        return response(0, null);
      }
      int result = activityService.update(activity);
      return new BaseResponse(StatusCode.SUCCESS, ResponseMsg.SUCCESS);
    } else {
      return response(null);
    }
  }

  /**
   *
   * @param id
   * @param activity
   * @return
   */
  @ApiOperation(value = "更改活动信息", notes = "更改活动信息", httpMethod = "PUT")
  @PutMapping("/activity/{id}")
  public BaseResponse updateActivityInfo(@PathVariable("id") Integer id,
      @RequestBody Activity activity) {
    activity.setId(id);
    int result = activityService.update(activity);
    return response(result, activity);
  }

  /**
   * 社团或社联获取自己未提交的经费表活动
   */
  @GetMapping("/uncommitted/money/usage/activity")
  public BaseResponse listMoneyUsage(HttpServletRequest request,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    User loginUser = getLoginUser(request);
    int role = loginUser.getRole().intValue();
//    System.out.println("============"+role);
    QActivity search = new QActivity();
    if (role == UserRole.CLUB_ADMIN.getCode() || role == UserRole.UNION_ADMIN.getCode()) {
      search.setUserId(loginUser.getId());
    } else {
      return FORBIDDEN;
    }
    search.setPage(page);
    search.setPageSize(pageSize);

    List<Activity> list = activityService.listUncommitMoneyUsageActivities(search, role);
    int totalCount;
    if (role == UserRole.CLUB_ADMIN.getCode()) {
      totalCount = activityService.countClubUncommitedUsageActivities(search);
    } else {
      totalCount = activityService.countUnionUncommitedUsageActivities(search);
    }
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }
}
