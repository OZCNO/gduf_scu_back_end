package org.scu.auth.vo;

import org.scu.base.conf.TargetType;

/**
 * Created by Lamm on 2018/12/19.
 */
public class QUserDataAuth {

  private Long userId;

  /**
   * {@link TargetType}
   */
  private Integer targetType;

  private Long targetId;

  public QUserDataAuth() {
  }

  public QUserDataAuth(Long userId, Integer targetType, Long targetId) {
    this.userId = userId;
    this.targetType = targetType;
    this.targetId = targetId;
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
}
