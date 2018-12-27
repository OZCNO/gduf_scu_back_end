package org.scu.user.service.impl;

import org.scu.user.conf.UserConf;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.mapper.UserLoginTokenMapper;
import org.scu.user.service.UserLoginTokenService;
import org.scu.user.vo.QUserLoginToken;
import org.scu.utils.RandomUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lamm on 2018/12/19.
 */
@Service
public class UserLoginTokenServiceImpl implements UserLoginTokenService {

  @Autowired
  private UserLoginTokenMapper mapper;

  @Override
  public int insert(UserLoginToken item) {
    return mapper.insert(item);
  }

  @Override
  public int update(UserLoginToken item) {
    return mapper.update(item);
  }

  @Override
  public int removeById(long id) {
    return mapper.removeById(id);
  }

  @Override
  public UserLoginToken getById(long id) {
    return mapper.getById(id);
  }

  @Override
  public long count(QUserLoginToken search) {
    return mapper.count(search);
  }

  @Override
  public List<UserLoginToken> list(QUserLoginToken search) {
    return mapper.list(search);
  }

  @Override
  public String generateToken() {
    return RandomUtil.randString(UserConf.DEFAULT_USER_LOGIN_TOKEN_LENGTH);
  }

  @Override
  @Transactional
  public UserLoginToken save(UserLoginToken loginToken) {
    mapper.removeByUserId(loginToken.getUserId());
    mapper.insert(loginToken);
    return loginToken;
  }
}
