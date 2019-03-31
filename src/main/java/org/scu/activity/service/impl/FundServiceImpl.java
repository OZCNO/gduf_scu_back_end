package org.scu.activity.service.impl;

import java.util.List;
import org.scu.activity.conf.ActivityType;
import org.scu.activity.entity.Fund;
import org.scu.activity.mapper.FundMapper;
import org.scu.activity.service.FundService;
import org.scu.activity.vo.VFund;
import org.scu.base.service.BaseDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2019/3/31
 */
@Service
public class FundServiceImpl implements FundService {

  @Autowired
  private FundMapper fundMapper;

  @Override
  public List<VFund> listFunds(ActivityType activityType) {
    return fundMapper.list(activityType.getCode());
  }
}
