package org.scu.club.vo;

import org.scu.student.entity.Student;

/**
 * Created by lynn on 2019/1/22
 */
public class VVip extends Student {

  private String department;

  private String major;

  private Integer departmentId;

  private String institudeName;

  public String getInstitudeName() {
    return institudeName;
  }

  public void setInstitudeName(String institudeName) {
    this.institudeName = institudeName;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }
}
