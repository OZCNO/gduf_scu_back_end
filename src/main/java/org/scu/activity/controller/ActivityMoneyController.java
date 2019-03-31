package org.scu.activity.controller;

import java.util.List;
import java.util.Map;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Money;
import org.scu.activity.service.ActivityMoneyService;
import org.scu.activity.vo.QActivityMoney;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lamm on 2019/3/30
 */
@RestController
public class ActivityMoneyController extends BaseController {

  @Autowired
  private ActivityMoneyService activityMoneyService;

  @PostMapping("/activity/{activityId}/money/usage/")
  public BaseResponse addMoneyUse(@PathVariable("activityId") Integer activityId,
      @RequestBody List<Money> moneyList) {
    int result = activityMoneyService.insertActivityMoneyUse(moneyList, activityId);
    return response(result);
  }

  @GetMapping("/{type}/{clubOrUnionId}/money/usage/")
  public BaseResponse getMoneyUseByActivityId(@PathVariable("type") String type,
      @PathVariable("clubOrUnionId") Integer clubOrUnionId,
      @RequestParam(required = false) Integer status) {
    QActivityMoney search = new QActivityMoney();
    search.setClubOrUnionId(clubOrUnionId);
    search.setStatus(status);
    List moneys;
    if (type.equals(ActivityType.CLUB_ACTIVITY.getTypeName())) {
      search.setType(ActivityType.CLUB_ACTIVITY.getCode());
    } else if (type.equals(ActivityType.UNION_ACTIVITY.getTypeName())) {
      search.setType(ActivityType.UNION_ACTIVITY.getCode());
    } else {
      return FORBIDDEN;
    }
    moneys = activityMoneyService.list(search);
    return response(moneys);
  }

  /**
   * 更改阅读状态
   * @return
   */
  @PutMapping("/activity/{activityId}/money/usage/read")
  public BaseResponse readMoneyUse(@PathVariable("activityId") Integer activityId) {
    int result = activityMoneyService.readMoneyUse(activityId);
    return response(result);
  }

  @GetMapping("/club/money/usage")
  public BaseResponse listAll(@RequestParam(required = false) Integer status) {
    QActivityMoney search = new QActivityMoney();
    search.setStatus(status);
    List moneys;
    moneys = activityMoneyService.listClubMoneyUsage(search);
    PaginationResult paginationResult = new PaginationResult(moneys);
    return response(paginationResult);
  }
}
