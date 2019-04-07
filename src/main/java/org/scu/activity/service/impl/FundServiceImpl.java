package org.scu.activity.service.impl;

import java.math.BigDecimal;
import java.util.Date;
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
 * Created by lamm on 2019/3/31
 */
@Service
public class FundServiceImpl implements FundService {

  @Autowired
  private FundMapper fundMapper;

  @Override
  public List<VFund> listFunds(ActivityType activityType) {
    return fundMapper.list(activityType.getCode());
  }

  @Override
  public int update(Fund fund) {
    if (fund.getMoneySum() != null) {
      if (fund.getMoneySum().compareTo(BigDecimal.ZERO) < 0) {
        return 0;
      }
    }
    fund.setUpdateTime(new Date());
    return fundMapper.update(fund);
  }
}
