package org.scu.club.conf;

/**
 * Created by lamm on 2019/1/26
 */
public enum ClubRole {

  OFFICER(0,"干事"),
  VIP(1,"会员");

  ClubRole(int code, String roleName) {
    this.code = code;
    this.roleName = roleName;
  }

  private int code;

  private String roleName;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
