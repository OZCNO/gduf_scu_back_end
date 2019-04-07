package org.scu.activity.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Fund;
import org.scu.activity.service.FundService;
import org.scu.activity.vo.VFund;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lamm on 2019/3/31
 */
@RestController
public class FundController extends BaseController {

  @Autowired
  private FundService fundService;

  @GetMapping("/{type}/funds")
  public BaseResponse listFunds(@PathVariable("type") String type) {
    List<VFund> list;
    if (type.equalsIgnoreCase(ActivityType.CLUB.getTypeName())) {
      list = fundService.listFunds(ActivityType.CLUB);
    } else if (type.equalsIgnoreCase(ActivityType.UNION.getTypeName())) {
      list = fundService.listFunds(ActivityType.UNION);
    } else {
      return FORBIDDEN;
    }
    PaginationResult paginationResult = new PaginationResult(list);
    return response(paginationResult);
  }

  @PutMapping("/{type}/funds/{id}")
  public BaseResponse update(@PathVariable("type") String type,
      @PathVariable("id") Integer id,
      @RequestBody Fund fund,
      HttpServletRequest request) {
    User loginUser = getLoginUser(request);
    fund.setId(id);
    if (type.equalsIgnoreCase(ActivityType.CLUB.getTypeName())) {
      if (!loginUser.getRole().equals(UserRole.UNION_ADMIN.getCode())) {
        return FORBIDDEN;
      }
      fund.setType(ActivityType.CLUB.getCode());
    } else if (type.equalsIgnoreCase(ActivityType.UNION.getTypeName())) {
      if (!loginUser.getRole().equals(UserRole.TEACHER_ADMIN.getCode())) {
        return FORBIDDEN;
      }
      fund.setType(ActivityType.UNION.getCode());
    } else {
      return FORBIDDEN;
    }
    int result = fundService.update(fund);
    return response(result, fund);
  }
}
