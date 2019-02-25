package org.scu.activity.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/23
 */
public class QActivity extends Pagination {

  private int status;

  private Long userId;

  private Integer clubId;

  public Integer getClubId() {
    return clubId;
  }

  public void setClubId(Integer clubId) {
    this.clubId = clubId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
