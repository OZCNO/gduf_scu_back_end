package org.scu.activity.controller;

import java.util.List;
import org.scu.activity.entity.Money;
import org.scu.activity.service.ActivityMoneyService;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lynn on 2019/3/30
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
}
