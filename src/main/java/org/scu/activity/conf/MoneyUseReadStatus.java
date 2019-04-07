package org.scu.activity.conf;

/**
 * Created by lamm on 2019/3/31
 */
public enum MoneyUseReadStatus {

  READ(1, "已读"),
  NOT_READ(0, "未读");

  MoneyUseReadStatus(int code, String status) {
    this.code = code;
    this.status = status;
  }

  private int code;

  private String status;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
