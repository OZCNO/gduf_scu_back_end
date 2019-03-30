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

  /**
   * 以下为申请加入时所填原因
   */
  private String reason;

  /**
   * 以下为申请加入时所填自我介绍
   */
  private String introduction;

  /**
   * 以下为申请加入时所传图片
   */
  private String image;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

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
