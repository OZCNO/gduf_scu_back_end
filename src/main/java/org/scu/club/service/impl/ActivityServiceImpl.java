package org.scu.club.service.impl;

import java.util.List;
import org.scu.club.entity.Activity;
import org.scu.club.service.ActivityService;
import org.scu.club.vo.QActivity;

/**
 * Created by lynn on 2019/1/23
 */
public class ActivityServiceImpl implements ActivityService {

  @Override
  public List<Activity> list(QActivity search) {
    return null;
  }

  @Override
  public long count(QActivity search) {
    return 0;
  }

  @Override
  public int insert(Activity item) {
    return 0;
  }

  @Override
  public int update(Activity item) {
    return 0;
  }

  @Override
  public int removeById(long id) {
    return 0;
  }

  @Override
  public Activity getById(long id) {
    return null;
  }
}
