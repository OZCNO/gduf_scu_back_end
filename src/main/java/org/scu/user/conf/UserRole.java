package org.scu.user.conf;

/**
 * Created by lamm on 2019/1/21
 */
public enum UserRole {

  STUDENT(1, "学生"),
  CLUB_ADMIN(2, "社团管理员"),
  UNION_ADMIN(3, "社联管理员"),
  TEACHER_ADMIN(4, "校团委管理人");

  UserRole(Integer code, String roleName) {
    this.code = code;
    this.roleName = roleName;
  }

  private Integer code;

  private String roleName;

  public Integer getCode() {
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
