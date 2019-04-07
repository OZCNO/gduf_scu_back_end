package org.scu.activity.service.impl;

import java.util.List;
import org.scu.activity.entity.ActivityResult;
import org.scu.activity.mapper.ActivityResultMapper;
import org.scu.activity.service.ActivityResultService;
import org.scu.activity.vo.QActivityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/4/7
 */
@Service
public class ActivityResultServiceImpl implements ActivityResultService {

  @Autowired
  private ActivityResultMapper activityResultMapper;

  @Override
  public List<ActivityResult> list(QActivityResult search) {
    return activityResultMapper.list(search);
  }

  @Override
  public int update(ActivityResult item) {
    return activityResultMapper.update(item);
  }

  @Override
  public long count(QActivityResult search) {
    return activityResultMapper.count(search);
  }

  @Override
  public int insert(ActivityResult item) {
    return 0;
  }

  @Override
  public int removeById(long id) {
    return 0;
  }

  @Override
  public ActivityResult getById(long id) {
    return null;
  }
}
