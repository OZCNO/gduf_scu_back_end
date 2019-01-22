package org.scu.club.controller;

import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.club.entity.Club;
import org.scu.club.service.ClubService;
import org.scu.club.vo.QClub;
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
public class MemberController extends BaseController {

  /**
   * 获取社团干事信息
   * @param name
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping("/club/member")
  public BaseResponse listMembers(@RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    return null;
  }


  @PutMapping("/club/member")
  public BaseResponse updateMemberInfo() {
    return null;
  }

  @PostMapping("/club/member")
  public BaseResponse addMemberInfo() {
    return null;
  }

  @DeleteMapping("/club/member/{id}")
  public BaseResponse removeMemberInfo(@PathVariable("id") Long id) {
    return null;
  }
}
