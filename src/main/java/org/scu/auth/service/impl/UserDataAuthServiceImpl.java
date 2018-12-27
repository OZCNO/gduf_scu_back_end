package org.scu.auth.service.impl;

import org.scu.auth.mapper.UserDataAuthMapper;
import org.scu.auth.vo.QUserDataAuth;
import org.scu.auth.conf.Role;
import org.scu.auth.entity.UserDataAuth;
import org.scu.auth.service.UserDataAuthService;
import org.scu.auth.vo.QUserMultiDataAuth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lamm on 2018/12/19.
 */
@Service
public class UserDataAuthServiceImpl implements UserDataAuthService {

  @Autowired
  private UserDataAuthMapper mapper;

  @Override
  public int insert(UserDataAuth item) {
    return mapper.insert(item);
  }

  @Override
  public UserDataAuth getByUserTarget(QUserDataAuth search) {
    return mapper.getByUserTarget(search);
  }

  @Override
  public boolean canRead(QUserDataAuth search) {
    UserDataAuth userDataAuth = mapper.getByUserTarget(search);
    if (userDataAuth == null) {
      return false;
    }
    return Role.ADMIN.getType().equals(userDataAuth.getRole()) ||
           Role.DEFAULT.getType().equals(userDataAuth.getRole());
  }

  @Override
  public boolean canWrite(QUserDataAuth search) {
    UserDataAuth userDataAuth = mapper.getByUserTarget(search);
    if (userDataAuth == null) {
      return false;
    }
    return Role.ADMIN.getType().equals(userDataAuth.getRole());
  }

  @Override
  public List<Long> filterIds(QUserMultiDataAuth search) {
    return mapper.filterTargetIds(search);
  }
}
