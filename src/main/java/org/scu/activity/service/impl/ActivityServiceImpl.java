package org.scu.activity.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.scu.activity.conf.ActivityStatus;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;
import org.scu.activity.mapper.ActivityMapper;
import org.scu.activity.service.ActivityService;
import org.scu.activity.vo.QActivity;
import org.scu.activity.vo.VActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lamm on 2019/1/23
 */
@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityMapper activityMapper;

  @Override
  public List<VActivity> listActivities(QActivity search, int type) {
    List<VActivity> list;
    if (type == ActivityType.UNION_ACTIVITY.getCode()) {
      list =  activityMapper.listUnionActivities(search);
    } else if (type == ActivityType.CLUB_ACTIVITY.getCode()) {
      list = activityMapper.listClubActivities(search);
    } else {
      list = activityMapper.listAll(search);
    }
    return list;
  }

  @Override
  public List<Activity> list(QActivity search) {
    return null;
  }

  @Override
  public long count(QActivity search) {
    return activityMapper.count(search);
  }

  @Deprecated
  @Override
  public int insert(Activity item) {
    return 0;
  }

  @Override
  @Transactional
  public int insert(Activity item, int type) {
    if (type == ActivityType.UNION_ACTIVITY.getCode()) {
      item.setType(ActivityType.UNION_ACTIVITY.getCode());
    } else {
      item.setType(ActivityType.CLUB_ACTIVITY.getCode());
    }
    item.setAuditStates(ActivityStatus.UNDER_REVIEW.getCode());
    int result = activityMapper.insert(item);
    return result;
  }

  @Override
  public int update(Activity item) {
    return activityMapper.update(item);
  }

  @Override
  public int removeById(long id) {
    return activityMapper.removeById(id);
  }

  @Override
  public Activity getById(long id) {
    return activityMapper.getById(id);
  }

  @Override
  public int countUnionActivities(QActivity search) {
    return activityMapper.countUnionActivities(search);
  }

  @Override
  public int countClubActivities(QActivity search) {
    return activityMapper.countClubActivities(search);
  }
}
