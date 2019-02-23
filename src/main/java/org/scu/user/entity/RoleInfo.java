package org.scu.user.entity;

import java.util.Date;

/**
 * Created by lynn on 2019/2/20
 */
public class RoleInfo {

  protected Integer id;

  protected Integer userId;

  protected Date createTime;

  protected Date updateTime;

  /**
   * 头像
   */
  protected String avatar;

  protected int role;

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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
