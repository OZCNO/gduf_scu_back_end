package org.scu.club.controller;

import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.club.service.ClubService;
import org.scu.club.vo.QClub;
import org.scu.club.vo.VClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2019/1/21
 */
@RestController
public class ClubController extends BaseController {

  @Autowired
  private ClubService clubService;

  /**
   * 获取社团列表
   */
  @GetMapping("/club")
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
  public BaseResponse getClub(@PathVariable("id") Long id) {
    return null;
  }

  /**
   * 提交社团活动申请
   * @return
   */
  @PostMapping("/club/activity/application")
  public BaseResponse applyActivity() {
    return null;
  }

  /**
   * 提交年度注册表
   * @return
   */
  @PostMapping("/club/annual/registration")
  public BaseResponse applyAnnualRegistration() {
    return null;
  }

  /**
   * 更新社团信息
   * @return
   */
  @PutMapping("/club/{id}")
  public BaseResponse updateAssociationInfo() {
    return null;
  }
}
