package org.scu.club.service.impl;

import org.scu.club.entity.ClubAdmin;
import org.scu.club.mapper.ClubAdminMapper;
import org.scu.club.service.ClubAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/2/23
 */
@Service
public class ClubAdminServiceImpl implements ClubAdminService {

  @Autowired
  private ClubAdminMapper clubAdminMapper;

  @Override
  public ClubAdmin getByUserId(long userId) {
    return clubAdminMapper.getByUserId(userId);
  }
}
