package org.scu.activity.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;
import org.scu.activity.vo.QActivityMoney;

/**
 * Created by lamm on 2019/3/30
 */
public interface ActivityMoneyMapper {

  int insertActivityMoneyUse(List<Money> moneys);

  List<Money> listMoneyUse(QActivityMoney search);

  int updateReadStatus(Map data);

  List<Activity> listClubMoneyUsage(QActivityMoney search);
}
