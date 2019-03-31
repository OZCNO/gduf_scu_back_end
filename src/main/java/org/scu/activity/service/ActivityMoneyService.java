package org.scu.activity.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Money;

/**
 * Created by lamm on 2019/3/30
 */

public interface ActivityMoneyService {

  int insertActivityMoneyUse(List<Money> moneyList, Integer activityId);

  List<Money> list(Integer clubOrUnionId, ActivityType activityType);
}
