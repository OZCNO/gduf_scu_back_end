package org.scu.user.service;

import org.scu.base.service.BaseDBService;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.scu.user.vo.QUser;

public interface UserService extends BaseDBService<QUser, User> {

  boolean isCorrectPass(String inputPass, String dbPass);

  String encryptPass(String password);

  RoleInfo getRoleInfo(User user);
}