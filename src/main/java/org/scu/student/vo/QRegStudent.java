package org.scu.student.vo;

import org.scu.base.vo.Pagination;
import org.scu.student.entity.Student;

/**
 * Created by lynn on 2019/2/4
 */
public class QRegStudent extends Pagination {

  private String username;

  private String password;

  private String name;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

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
}
