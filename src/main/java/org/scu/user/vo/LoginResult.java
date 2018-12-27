package org.scu.user.vo;

/**
 * Created by Lamm on 2018/12/19.
 */
public class LoginResult {

  private LoginCredential credential;

  private LoginUserInfo user;

  public LoginCredential getCredential() {
    return credential;
  }

  public void setCredential(LoginCredential credential) {
    this.credential = credential;
  }

  public LoginUserInfo getUser() {
    return user;
  }

  public void setUser(LoginUserInfo user) {
    this.user = user;
  }
}
