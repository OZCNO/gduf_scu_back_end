package org.scu.auth.mapper;

import org.scu.auth.entity.UserDataAuth;
import org.scu.auth.vo.QUserDataAuth;
import org.scu.auth.vo.QUserMultiDataAuth;

import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface UserDataAuthMapper {

  int insert(UserDataAuth item);

  UserDataAuth getByUserTarget(QUserDataAuth search);

  List<Long> filterTargetIds(QUserMultiDataAuth search);
}
