package org.scu.activity.controller;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.service.FundService;
import org.scu.activity.vo.VFund;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lynn on 2019/3/31
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
    } else if(type.equalsIgnoreCase(ActivityType.UNION.getTypeName())) {
      list = fundService.listFunds(ActivityType.UNION);
    } else {
      return FORBIDDEN;
    }
    PaginationResult paginationResult = new PaginationResult(list);
    return response(paginationResult);
  }
}
