package org.scu.user.vo;

import org.scu.base.vo.Pagination;
import org.scu.user.conf.UserRole;

/**
 * Created by Lamm on 2018/12/19.
 */
public class QUser extends Pagination {

  private Long id;

  private String username;

  private String password;

  private int role;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

}
