package org.scu.user.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by Lamm on 2018/12/19.
 */
public class LoginCredential extends Pagination {

  private Long userId;

  private String token;

  public LoginCredential(Long userId, String token) {
    this.userId = userId;
    this.token = token;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
