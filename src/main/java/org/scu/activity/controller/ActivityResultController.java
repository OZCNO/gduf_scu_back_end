package org.scu.activity.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.scu.activity.conf.ActivityStatus;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.ActivityResult;
import org.scu.activity.service.ActivityResultService;
import org.scu.activity.vo.QActivity;
import org.scu.activity.vo.QActivityResult;
import org.scu.activity.vo.VActivity;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.student.entity.Student;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lamm on 2019/4/7
 */
@RestController
public class ActivityResultController extends BaseController {

  @Autowired
  private ActivityResultService activityResultService;


  @ApiOperation(value = "提交活动成果", notes = "提交活动成果{type}为club或union", httpMethod = "POST")
  @PostMapping("/activity/{id}/result")
  public BaseResponse commitActivityResult(@PathVariable("id") Integer id,
      @RequestBody ActivityResult activityResult) {
    int result;
    activityResult.setId(id);
    result = activityResultService.update(activityResult);
    return response(result, activityResult);
  }

  @ApiOperation(value = "学生获取活动成果信息列表", notes = "学生获取活动成果信息列表", httpMethod = "GET")
  @GetMapping(value = "/activity/result")
  public BaseResponse listActivities(HttpServletRequest request,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    User loginUser = getLoginUser(request);
    if (!loginUser.getRole().equals(UserRole.STUDENT.getCode())) {
      return FORBIDDEN;
    }
    QActivityResult search = new QActivityResult();
    search.setPage(page);
    search.setPageSize(pageSize);
    List<ActivityResult> list = activityResultService.list(search);
    Long totalCount = activityResultService.count(search);
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }
}
