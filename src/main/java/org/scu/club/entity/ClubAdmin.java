package org.scu.club.entity;

import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;

/**
 * Created by lamm on 2019/1/21
 */
public class ClubAdmin extends RoleInfo {

  private int clubId;

  private String clubName;

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public int getClubId() {
    return clubId;
  }

  public void setClubId(int clubId) {
    this.clubId = clubId;
  }

  @Override
  public int getRole() {
    return UserRole.CLUB_ADMIN.getCode();
  }
}
