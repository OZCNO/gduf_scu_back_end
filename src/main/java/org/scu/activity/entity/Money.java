package org.scu.activity.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 经费
 * Created by lamm on 2019/3/30
 */
public class Money {

  private Integer id;

  private Integer activityId;

  private String use;

  private BigDecimal sum;

  private int read;

  private Date createTime;

  private Date updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activity_id) {
    this.activityId = activityId;
  }

  public String getUse() {
    return use;
  }

  public void setUse(String use) {
    this.use = use;
  }

  public BigDecimal getSum() {
    return sum;
  }

  public void setSum(BigDecimal sum) {
    this.sum = sum;
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

  public int getRead() {
    return read;
  }

  public void setRead(int read) {
    this.read = read;
  }
}
