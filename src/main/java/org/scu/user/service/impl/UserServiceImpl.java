package org.scu.user.service.impl;

import org.scu.user.service.UserService;
import org.scu.user.conf.UserConf;
import org.scu.user.entity.User;
import org.scu.user.mapper.UserMapper;
import org.scu.user.vo.QUser;
import org.scu.utils.MD5Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lamm on 2018/12/19.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public String encryptPass(String password) {
    String encryptPass = MD5Util.encrypt(UserConf.DEFAULT_ENCRYPT_PREFIX_SALT + password + UserConf.DEFAULT_ENCRYPT_SUFFIXSALT);
    return encryptPass;
  }

  @Override
  public boolean isCorrectPass(String inputPass, String dbPass) {
    String encryptPass = encryptPass(inputPass);
    if (encryptPass.equals(dbPass)) {
      return true;
    }
    return false;
  }

  @Override
  public int insert(User item) {
    return userMapper.insert(item);
  }

  @Override
  public int update(User item) {
    return userMapper.update(item);
  }

  @Override
  public int removeById(long id) {
    return userMapper.removeById(id);
  }

  @Override
  public List<User> list(QUser search) {
    return userMapper.list(search);
  }

  @Override
  public long count(QUser search) {
    return userMapper.count(search);
  }

  @Override
  public User getById(long id) {
    return userMapper.getById(id);
  }

  public static void main(String[] args) {
    String password = "123456";
    String encryptPass = MD5Util.encrypt(UserConf.DEFAULT_ENCRYPT_PREFIX_SALT + password + UserConf.DEFAULT_ENCRYPT_SUFFIXSALT);
    System.out.println(encryptPass);
  }
}
