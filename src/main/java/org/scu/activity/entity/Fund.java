package org.scu.activity.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 社团 、 社联经费
 * Created by lynn on 2019/3/31
 */
public class Fund {

  private Integer id;

  private Integer clubUnionId;

  private Integer type;

  private BigDecimal moneySum;

  private Date createTime;

  private Date updateTime;

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

  public BigDecimal getMoneySum() {
    return moneySum;
  }

  public void setMoneySum(BigDecimal moneySum) {
    this.moneySum = moneySum;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
