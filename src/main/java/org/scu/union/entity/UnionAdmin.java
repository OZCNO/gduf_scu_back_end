package org.scu.union.entity;

import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;

/**
 * Created by lynn on 2019/1/21
 */
public class UnionAdmin extends RoleInfo {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getRole() {
    return UserRole.UNION_ADMIN.getCode();
  }
}
