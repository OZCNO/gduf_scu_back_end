package org.scu.club.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/26
 */
public class QAnnualRegistration extends Pagination {

//  private String name;

  private Integer status;

  private Long userId;

  private String reason;

  private String clubType;

  public String getClubType() {
    return clubType;
  }

  public void setClubType(String clubType) {
    this.clubType = clubType;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
