package org.scu.club.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.scu.activity.conf.AnnualRegStatus;
import org.scu.auth.conf.Role;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.club.entity.AnnualRegistration;
import org.scu.club.mapper.AnnualRegistrationMapper;
import org.scu.club.service.AnnualRegistrationService;
import org.scu.club.service.ClubService;
import org.scu.club.vo.QAnnualRegistration;
import org.scu.club.vo.QClub;
import org.scu.club.vo.VClub;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
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
@Api(description = "社团", tags = {"社团"})
@RestController
public class ClubController extends BaseController {

  @Autowired
  private ClubService clubService;

  @Autowired
  private AnnualRegistrationService annualRegistrationService;

  /**
   * 获取社团列表
   */
  @GetMapping("/club")
  @ApiOperation(value = "获取社团信息列表", notes = "获取社团信息列表", httpMethod = "GET")
  public BaseResponse listClubs(@RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    QClub search = new QClub();
    search.setName(name);
    search.setPage(page);
    search.setPageSize(pageSize);
    List<VClub> clubList = clubService.listClubs(search);
    PaginationResult paginationResult = new PaginationResult(clubList);
    return response(paginationResult);
  }

  /**
   * 根据id获取社团信息
   */
  @GetMapping("/club/{id}")
  public BaseResponse getClub(@PathVariable("id") Integer id) {
    return null;
  }

  /**
   * 提交年度注册表
   * @return
   */
  @PostMapping("/club/{id}/annual/registration")
  @ApiOperation(value = "提交年度注册表", notes = "提交年度注册表", httpMethod = "GET")
  public BaseResponse applyAnnualRegistration(@PathVariable("id") Integer id,
      @RequestBody AnnualRegistration info) {
    info.setAuditStatus(AnnualRegStatus.UNDER_REVIEW.getCode());
    int result = annualRegistrationService.insert(info);
    return response(result, info);
  }

  /**
   * 更新社团信息
   * @return
   */
  @PutMapping("/club/{id}")
  public BaseResponse updateAssociationInfo(@PathVariable("id") Integer id) {
    return null;
  }

  @GetMapping("/club/annual/registration")
  @ApiOperation(value = "社联/社团获取年度注册表列表", notes = "获取年度注册表列表", httpMethod = "GET")
  public BaseResponse listAnnualRegistration(HttpServletRequest request,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    User loginUser = getLoginUser(request);
    QAnnualRegistration search = new QAnnualRegistration();
    if (loginUser.getRole().equals(UserRole.CLUB_ADMIN.getCode())) {
      search.setUserId(loginUser.getId());
    } else if (loginUser.getRole().equals(UserRole.UNION_ADMIN.getCode())) {

    } else {
      return FORBIDDEN;
    }
    search.setPage(page);
    search.setPageSize(pageSize);
    List<AnnualRegistration> list = annualRegistrationService.list(search);
    long totalCount = annualRegistrationService.count(search);
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }
}
