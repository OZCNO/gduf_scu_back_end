package org.scu.activity.mapper;

import java.util.List;
import org.scu.activity.vo.VActivity;
import org.scu.base.mapper.BaseMapper;
import org.scu.activity.entity.Activity;
import org.scu.activity.vo.QActivity;

/**
 * Created by lynn on 2019/1/23
 */
public interface ActivityMapper extends BaseMapper<QActivity, Activity> {

  List<VActivity> listClubActivities(QActivity search);

  List<VActivity> listUnionActivities(QActivity search);
}
