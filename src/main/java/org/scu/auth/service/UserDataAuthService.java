package org.scu.auth.service;

import org.scu.auth.vo.QUserDataAuth;
import org.scu.auth.entity.UserDataAuth;
import org.scu.auth.vo.QUserMultiDataAuth;
import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface UserDataAuthService {

  int insert(UserDataAuth item);

  UserDataAuth getByUserTarget(QUserDataAuth search);

  boolean canRead(QUserDataAuth search);

  boolean canWrite(QUserDataAuth search);

  List<Long> filterIds(QUserMultiDataAuth search);
}
