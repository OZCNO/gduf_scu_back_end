package org.scu.user.vo;

import org.scu.user.entity.User;

/**
 * Created by Lamm on 2018/12/19.
 */
public class LoginUserInfo {

  private Long id;

  private String name;

  public LoginUserInfo(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
