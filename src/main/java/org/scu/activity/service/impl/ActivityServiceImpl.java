package org.scu.activity.service.impl;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Activity;
import org.scu.activity.mapper.ActivityMapper;
import org.scu.activity.service.ActivityService;
import org.scu.activity.vo.QActivity;
import org.scu.activity.vo.VActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2019/1/23
 */
@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityMapper activityMapper;

  @Override
  public List<VActivity> listActivities(QActivity search, int type) {
    if (type == ActivityType.UNION_ACTIVITY.getCode()) {
      return activityMapper.listUnionActivities(search);
    } else {
      return activityMapper.listClubActivities(search);
    }
  }

  @Override
  public List<Activity> list(QActivity search) {
    return null;
  }

  @Override
  public long count(QActivity search) {
    return 0;
  }

  @Deprecated
  @Override
  public int insert(Activity item) {
    return 0;
  }

  @Override
  public int insert(Activity item, int type) {
    if (type == ActivityType.UNION_ACTIVITY.getCode()) {
      item.setType(ActivityType.UNION_ACTIVITY.getCode());
    } else {
      item.setType(ActivityType.CLUB_ACTIVITY.getCode());
    }
    return activityMapper.insert(item);
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
}
