package org.scu.activity.entity;

/**
 * 社团 、 社联经费
 * Created by lynn on 2019/3/31
 */
public class Fund {

  private Integer id;

  private Integer clubUnionId;

  private Integer type;

  private String moneySum;

  private String createTime;

  private String updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getClubUnionId() {
    return clubUnionId;
  }

  public void setClubUnionId(Integer clubUnionId) {
    this.clubUnionId = clubUnionId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getMoneySum() {
    return moneySum;
  }

  public void setMoneySum(String moneySum) {
    this.moneySum = moneySum;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
}
