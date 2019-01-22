package org.scu.user.entity;

import org.scu.user.conf.UserRole;

/**
 * Created by lynn on 2019/1/21
 */
public class UnionAdmin extends User {

  @Override
  public Integer getRole() {
    return UserRole.UNION_ADMIN.getCode();
  }
}
