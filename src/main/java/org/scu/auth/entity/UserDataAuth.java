package org.scu.auth.entity;

import org.scu.auth.conf.Role;
import org.scu.base.conf.TargetType;

import java.util.Date;

/**
 * Created by Lamm on 2018/12/19.
 */
public class UserDataAuth {

  private Long id;

  private Long userId;

  /**
   * {{@link TargetType}
   */
  private Integer targetType;

  private Long targetId;

  /**
   * {@link Role}
   */
  private Integer role;

  private Date createTime;

  private Date updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Integer getTargetType() {
    return targetType;
  }

  public void setTargetType(Integer targetType) {
    this.targetType = targetType;
  }

  public Long getTargetId() {
    return targetId;
  }

  public void setTargetId(Long targetId) {
    this.targetId = targetId;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
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
