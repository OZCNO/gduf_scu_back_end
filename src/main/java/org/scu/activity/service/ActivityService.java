package org.scu.activity.service;

import java.util.List;
import org.scu.activity.vo.VActivity;
import org.scu.base.service.BaseDBService;
import org.scu.activity.entity.Activity;
import org.scu.activity.vo.QActivity;

/**
 * Created by lamm on 2019/1/23
 */
public interface ActivityService extends BaseDBService<QActivity, Activity> {

  List<VActivity> listActivities(QActivity search, int type);

  int insert(Activity item, int type);

  int countUnionActivities(QActivity search);

  int countClubActivities(QActivity search);
}
