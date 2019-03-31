package org.scu.activity.service;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Fund;
import org.scu.activity.vo.VFund;

/**
 * Created by lynn on 2019/3/31
 */
public interface FundService {

  List<VFund> listFunds(ActivityType activityType);

  int update(Fund fund);
}
