package org.scu.user.entity;

/**
 * Created by Lamm on 2018/12/19.
 */
public class User {

  private Long id;

  private String name;

  private String password;

  private Long supervisorId;

  private Integer role;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getSupervisorId() {
    return supervisorId;
  }

  public void setSupervisorId(Long supervisorId) {
    this.supervisorId = supervisorId;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }
}
