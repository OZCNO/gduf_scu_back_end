package org.scu.club.entity;

import java.util.Date;

/**
 * 社团活动
 * Created by Lamm on 2019/1/21
 */
public class Activity {

  private Integer id;

  private Integer clubUnionId;

  // 区分社团 or 社联
  private int type;

  private String theme;

  private String content;

  private int memberActivity;

  // 活动开始时间
  private Date time;

  // 报名截止时间
  private Date enrollDeadline;

  // 活动审核状态
  private int auditStates;

  private String introduction;

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

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

  public int getType() {
    return type;
  }

  public void setType(int type) {
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

  public int getMemberActivity() {
    return memberActivity;
  }

  public void setMemberActivity(int memberActivity) {
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

  public int getAuditStates() {
    return auditStates;
  }

  public void setAuditStates(int auditStates) {
    this.auditStates = auditStates;
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
