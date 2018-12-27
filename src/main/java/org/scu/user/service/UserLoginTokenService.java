package org.scu.user.service;

import org.scu.user.vo.QUserLoginToken;
import org.scu.base.service.BaseDBService;
import org.scu.user.entity.UserLoginToken;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface UserLoginTokenService extends BaseDBService<QUserLoginToken, UserLoginToken> {

  String generateToken();

  UserLoginToken save(UserLoginToken loginToken);
}
