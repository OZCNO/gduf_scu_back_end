package org.scu.base.conf;

/**
 * Created by Lamm on 2018/12/19.
 */
public enum TargetType {

  COMPANY(Integer.valueOf(1), "公司"),
  PRODUCT(Integer.valueOf(2), "产品"),
  CLIENTS(Integer.valueOf(3), "客户");

  private TargetType(Integer type, String name) {
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
