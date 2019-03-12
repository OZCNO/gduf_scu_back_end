package org.scu.auth.conf;

/**
 * Created by Lamm on 2018/12/19.
    */
  public enum Role {

    ADMIN(Integer.valueOf(0), "管理员"),
    DEFAULT(Integer.valueOf(1), "普通用户");

    Role(Integer type, String name) {
      this.type = type;
      this.name = name;
    }

    private Integer type;

    private String name;

    public Integer getType() {
      return type;
    }

  public String getName() {
    return name;
  }
}
