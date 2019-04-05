package org.scu.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.entity.Money;
import org.scu.activity.vo.VActivity;
import org.scu.base.mapper.BaseMapper;
import org.scu.activity.entity.Activity;
import org.scu.activity.vo.QActivity;

/**
 * Created by lamm on 2019/1/23
 */
public interface ActivityMapper extends BaseMapper<QActivity, Activity> {

  List<VActivity> listClubActivities(QActivity search);

  List<VActivity> listUnionActivities(QActivity search);

  List<VActivity> listAll(QActivity search);

  int countClubActivities(QActivity search);

  int countUnionActivities(QActivity search);

  List<Activity> listClubUncommitedUsageActivities(QActivity search);

  List<Activity> listUnionUncommitedUsageActivities(QActivity search);

  int countClubUncommitedUsageActivities(QActivity search);

  int countUnionUncommitedUsageActivities(QActivity search);
}
