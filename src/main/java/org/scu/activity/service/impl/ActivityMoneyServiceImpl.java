package org.scu.activity.service.impl;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;
import org.scu.activity.mapper.ActivityMoneyMapper;
import org.scu.activity.service.ActivityMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/3/30
 */
@Service
public class ActivityMoneyServiceImpl implements ActivityMoneyService {

  @Autowired
  private ActivityMoneyMapper activityMoneyMapper;

  @Override
  public int insertActivityMoneyUse(List<Money> moneyList, Integer activityId) {
    for (int i = 0; i < moneyList.size(); i++) {
      moneyList.get(i).setActivityId(activityId);
    }
    return activityMoneyMapper.insertActivityMoneyUse(moneyList);
  }

  @Override
  public List<Money> list(Integer clubOrUnionId, ActivityType activityType) {
    return activityMoneyMapper.listMoneyUse(clubOrUnionId, activityType.getCode());
  }
}
