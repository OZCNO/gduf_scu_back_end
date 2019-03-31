package org.scu.activity.vo;

import org.scu.activity.conf.ActivityType;

/**
 * Created by lynn on 2019/3/31
 */
public class QActivityMoney {

  private Integer status;

  private Integer clubOrUnionId;

  private Integer type;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getClubOrUnionId() {
    return clubOrUnionId;
  }

  public void setClubOrUnionId(Integer clubOrUnionId) {
    this.clubOrUnionId = clubOrUnionId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
