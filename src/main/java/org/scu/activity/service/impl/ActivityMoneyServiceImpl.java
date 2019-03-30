package org.scu.activity.service.impl;

import java.util.List;
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
  public int insertActivityMoneyUse(List<Money> moneyList) {
    return activityMoneyMapper.insertActivityMoneyUse(moneyList);
  }

  @Override
  public List<Money> getMoneyUse(Integer activityId) {
    return activityMoneyMapper.getMoneyUse(activityId);
  }
}
