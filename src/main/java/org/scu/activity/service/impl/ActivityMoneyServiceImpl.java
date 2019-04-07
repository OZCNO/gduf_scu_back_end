package org.scu.activity.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.conf.MoneyUseReadStatus;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;
import org.scu.activity.mapper.ActivityMapper;
import org.scu.activity.mapper.ActivityMoneyMapper;
import org.scu.activity.service.ActivityMoneyService;
import org.scu.activity.vo.QActivityMoney;
import org.scu.club.entity.Club;
import org.scu.club.mapper.ClubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/3/30
 */
@Service
public class ActivityMoneyServiceImpl implements ActivityMoneyService {

  @Autowired
  private ActivityMoneyMapper activityMoneyMapper;

  @Autowired
  private ActivityMapper activityMapper;

  @Autowired
  private ClubMapper clubMapper;

  @Override
  public int insertActivityMoneyUse(List<Money> moneyList, Integer activityId) {
    Date current = new Date();
    for (int i = 0; i < moneyList.size(); i++) {
      moneyList.get(i).setActivityId(activityId);
      moneyList.get(i).setCreateTime(current);
      moneyList.get(i).setUpdateTime(current);
    }
    return activityMoneyMapper.insertActivityMoneyUse(moneyList);
  }

  @Override
  public List list(QActivityMoney search) {
    List<Money> moneyList = activityMoneyMapper.listMoneyUse(search);
    Set<Integer> activityIds = moneyList.stream().map(Money::getActivityId)
        .collect(Collectors.toSet());
    List<Map<String, Object>> resultList = new ArrayList<>();
    activityIds.forEach(item -> {
      Map<String, Object> map = new HashMap<>();
      map.put("activityId", item);
      map.put("moneyUse",
          moneyList.stream().filter(money -> money.getActivityId().equals(item)).collect(
              Collectors.toList()));
      Activity activity = activityMapper.getById(item);
      if (activity != null) {
        if (activity.getType() == ActivityType.CLUB.getCode()) {
          Club club = clubMapper.getClub(activity.getClubUnionId());
          map.put("clubName", club.getName());
        } else {
          map.put("clubName", "广东金融学院学生社团联合会");
        }
        map.put("theme", activity.getTheme());
        map.put("money", activity.getMoney());
        map.put("timeBegin", activity.getTimeBegin());
      }
      resultList.add(map);
    });
    return resultList;
  }

  @Override
  public int readMoneyUse(Integer activityId) {
    Map<String, Object> map = new HashMap<>();
    map.put("read", MoneyUseReadStatus.READ.getCode());
    map.put("updateTime", new Date());
    map.put("activityId", activityId);
    return activityMoneyMapper.updateReadStatus(map);
  }

  @Override
  public List<Activity> listClubMoneyUsage(QActivityMoney search) {
    return activityMoneyMapper.listClubMoneyUsage(search);
  }

  @Override
  public List<Activity> listUnionMoneyUsage(QActivityMoney search) {
    return activityMoneyMapper.listUnionMoneyUsage(search);
  }
}
