package org.scu.activity.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lamm on 2019/1/23
 */
public class QActivity extends Pagination {

  private Integer status;

  private Long userId;

  private Integer clubId;

  private Integer memberActivity;

  private Integer StudentId;

  private Integer commitResult;

  public Integer getStudentId() {
    return StudentId;
  }

  public void setStudentId(Integer studentId) {
    StudentId = studentId;
  }

  public Integer getMemberActivity() {
    return memberActivity;
  }

  public void setMemberActivity(Integer memberActivity) {
    this.memberActivity = memberActivity;
  }

  public Integer getClubId() {
    return clubId;
  }

  public void setClubId(Integer clubId) {
    this.clubId = clubId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getCommitResult() {
    return commitResult;
  }

  public void setCommitResult(Integer commitResult) {
    this.commitResult = commitResult;
  }
}
