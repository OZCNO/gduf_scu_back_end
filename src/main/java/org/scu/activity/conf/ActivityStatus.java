package org.scu.activity.conf;

/**
 * Created by lamm on 2019/1/26
 */
public enum ActivityStatus {

  UNDER_REVIEW(1,"审核中"),
  PASS(2,"审核通过"),
  NOT_PASS(3,"审核不通过"),
  PUBLISHED(4,"已发布");

  ActivityStatus(int code, String statusName) {
    this.code = code;
    this.statusName = statusName;
  }

  private int code;

  private String statusName;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }
}
