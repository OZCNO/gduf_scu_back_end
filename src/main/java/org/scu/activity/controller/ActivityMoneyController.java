package org.scu.activity.controller;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Money;
import org.scu.activity.service.ActivityMoneyService;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      @PathVariable("clubOrUnionId") Integer clubOrUnionId) {
    List<Money> moneys;
    if (type.equals(ActivityType.CLUB_ACTIVITY.getTypeName())) {
      moneys = activityMoneyService.list(clubOrUnionId, ActivityType.CLUB_ACTIVITY);
    } else if (type.equals(ActivityType.UNION_ACTIVITY.getTypeName())) {
      moneys = activityMoneyService.list(clubOrUnionId, ActivityType.UNION_ACTIVITY);
    } else {
      return FORBIDDEN;
    }
    PaginationResult paginationResult = new PaginationResult(moneys);
    return response(paginationResult);
  }
}
