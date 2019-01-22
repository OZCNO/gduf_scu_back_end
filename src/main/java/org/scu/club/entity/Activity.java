package org.scu.club.entity;

import java.util.Date;

/**
 * 社团活动
 * Created by Lamm on 2019/1/21
 */
public class Activity {

  private Integer id;

  private Integer clubUnionId;

  private short type;

  private String theme;

  private String content;

  private short memberActivity;

  // 活动开始时间
  private Date time;

  // 报名截止时间
  private Date enrollDeadline;

  // 活动审核状态
  private short audit_states;

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

  public short getType() {
    return type;
  }

  public void setType(short type) {
    this.type = type;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public short getMemberActivity() {
    return memberActivity;
  }

  public void setMemberActivity(short memberActivity) {
    this.memberActivity = memberActivity;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Date getEnrollDeadline() {
    return enrollDeadline;
  }

  public void setEnrollDeadline(Date enrollDeadline) {
    this.enrollDeadline = enrollDeadline;
  }

  public short getAudit_states() {
    return audit_states;
  }

  public void setAudit_states(short audit_states) {
    this.audit_states = audit_states;
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
