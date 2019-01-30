package org.scu.club.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.base.vo.Pagination;
import org.scu.club.vo.VVip;
import org.scu.student.mapper.StudentMapper;
import org.scu.student.service.StudentService;
import org.scu.student.vo.QStudent;
import org.scu.user.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private StudentService studentService;

  /**
   * 获取会员/干事信息
   * @param name
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping(value = "/club/{id}/vip")
  @ApiOperation(value = "获取社团会员/干事列表", notes = "获取社团会员/干事列表", httpMethod = "GET")
  public BaseResponse listVips(@PathVariable("id") Integer clubId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer role,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    QStudent search = new QStudent();
    search.setClubId(clubId);
    search.setRole(role);
    search.setName(name);
    search.setPage(page);
    search.setPageSize(pageSize);
    List<VVip> vipList = studentService.listClubVips(search);
    PaginationResult paginationResult = new PaginationResult(vipList);
    return response(paginationResult);
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
