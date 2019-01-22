package org.scu.club.controller;

import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.club.vo.VVip;
import org.scu.student.vo.QStudent;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class VipController extends BaseController{

  /**
   * 获取会员信息
   * @param name
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping(value = "/club/{id}/vip")
  public BaseResponse listVips(@RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    QStudent search = new QStudent();
    search.setName(name);
    search.setPage(page);
    search.setPageSize(pageSize);
//    List<VVip> vipList =
    return null;
  }

  @PostMapping(value = "/club/vip")
  public BaseResponse addVipInfo() {
    return null;
  }

  @PutMapping(value = "/club/vip")
  public BaseResponse updateVipInfo() {
    return null;
  }

  @DeleteMapping(value = "/club/vip/{id}")
  public BaseResponse removeVipInfo(@PathVariable("id") Long id) {
    return null;
  }
}
