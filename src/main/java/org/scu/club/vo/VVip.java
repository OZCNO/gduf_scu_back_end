package org.scu.club.vo;

import org.scu.student.entity.Student;

/**
 * Created by lynn on 2019/1/22
 */
public class VVip extends Student {

  private String departmentName;

  private String major;

  private Integer departmentId;

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
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
