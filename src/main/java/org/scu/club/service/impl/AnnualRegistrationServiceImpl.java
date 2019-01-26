package org.scu.club.service.impl;

import java.util.List;
import org.scu.club.entity.AnnualRegistration;
import org.scu.club.mapper.AnnualRegistrationMapper;
import org.scu.club.service.AnnualRegistrationService;
import org.scu.club.vo.QAnnualRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2019/1/26
 */
@Service
public class AnnualRegistrationServiceImpl implements AnnualRegistrationService {

  @Autowired
  private AnnualRegistrationMapper annualRegistrationMapper;

  @Override
  public int insert(AnnualRegistration item) {
    return annualRegistrationMapper.insert(item);
  }

  @Override
  public List<AnnualRegistration> list(QAnnualRegistration search) {
    return annualRegistrationMapper.list(search);
  }

  @Override
  public long count(QAnnualRegistration search) {
    return annualRegistrationMapper.count(search);
  }

  @Override
  public int update(AnnualRegistration item) {
    return annualRegistrationMapper.update(item);
  }

  @Override
  public int removeById(long id) {
    return 0;
  }

  @Override
  public AnnualRegistration getById(long id) {
    return null;
  }
}
