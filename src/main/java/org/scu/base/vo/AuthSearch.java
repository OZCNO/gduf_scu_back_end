package org.scu.base.vo;

/**
 * Created by Lamm on 2018/12/19.
 */
public class AuthSearch extends Pagination {

  private Integer targetType;

  private Long currentUserId;

  public Integer getTargetType() {
    return targetType;
  }

  public void setTargetType(Integer targetType) {
    this.targetType = targetType;
  }

  public Long getCurrentUserId() {
    return currentUserId;
  }

  public void setCurrentUserId(Long currentUserId) {
    this.currentUserId = currentUserId;
  }
}
