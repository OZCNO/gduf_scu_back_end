package org.scu.activity.conf;

/**
 * Created by lynn on 2019/1/23
 */
public enum ActivityType {

  UNION_ACTIVITY(1, "union"),
  CLUB_ACTIVITY(2, "club"),
  All(0, "all");

  ActivityType(int code, String typeName) {
    this.code = code;
    this.typeName = typeName;
  }

  private int code;

  private String typeName;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
