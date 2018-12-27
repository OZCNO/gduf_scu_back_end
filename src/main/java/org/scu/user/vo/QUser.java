package org.scu.user.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by Lamm on 2018/12/19.
 */
public class QUser extends Pagination {

  private Long id;

  private String name;

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
