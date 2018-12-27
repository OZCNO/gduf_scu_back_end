package org.scu.auth.vo;

import org.scu.base.conf.TargetType;
import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public class QUserMultiDataAuth {

  private Long userId;

  /**
   * {@link TargetType}
   */
  private Integer targetType;

  private List<Long> targetIds;

  private Integer role;

  public QUserMultiDataAuth() {
  }

  public QUserMultiDataAuth(Long userId, Integer targetType, List<Long> targetId) {
    this.userId = userId;
    this.targetType = targetType;
    this.targetIds = targetId;
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

  public List<Long> getTargetIds() {
    return targetIds;
  }

  public void setTargetIds(List<Long> targetIds) {
    this.targetIds = targetIds;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }
}
