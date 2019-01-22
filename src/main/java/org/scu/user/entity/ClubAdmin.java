package org.scu.user.entity;

import org.scu.user.conf.UserRole;

/**
 * Created by lynn on 2019/1/21
 */
public class ClubAdmin extends User {

  @Override
  public Integer getRole() {
    return UserRole.CLUB_ADMIN.getCode();
  }
}
