package org.scu.student.conf;

/**
 * Created by lamm on 2019/2/23
 */
public enum  Gender {

  MALE(0, "男"),
  FEMALE(1, "女"),
  UNKNOW(-1, "未知");

  private int gender;

  private String value;

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  Gender(int gender, String value) {
    this.gender = gender;
    this.value = value;
  }
}
