package org.scu.activity.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;
import org.scu.activity.vo.QActivityMoney;

/**
 * Created by lamm on 2019/3/30
 */

public interface ActivityMoneyService {

  int insertActivityMoneyUse(List<Money> moneyList, Integer activityId);

  List list(QActivityMoney search);

  int readMoneyUse(Integer activityId);

  List<Activity> listClubMoneyUsage(QActivityMoney search);

  List<Activity> listUnionMoneyUsage(QActivityMoney search);
}
