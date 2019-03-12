package org.scu.student.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;

/**
 * @author lamm
 */
public class Student extends RoleInfo {

  /**
   * 姓名 isNullAble:0
   */
  private String name;

  /**
   * 性别 isNullAble:0
   */
  private int sex;

  /**
   * 专业编号 isNullAble:0
   */
  private Integer majorId;

  /**
   * 学号 isNullAble:0
   */
  private String code;

  /**
   * 邮箱 isNullAble:0
   */
  private String email;

  /**
   * 手机 isNullAble:0
   */
  private String mobile;

  /**
   * 学院名称
   */
  private String institude;

  /**
   * 专业
   */
  private String major;

  /**
   * 学生所加入的社团
   */
  private List<Map<String, Object>> stuJoinClubs;

  public List<Map<String, Object>> getStuJoinClubs() {
    return stuJoinClubs;
  }

  public void setStuJoinClubs(
      List<Map<String, Object>> stuJoinClubs) {
    this.stuJoinClubs = stuJoinClubs;
  }

  public String getInstitude() {
    return institude;
  }

  public void setInstitude(String institude) {
    this.institude = institude;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public Integer getSex() {
    return this.sex;
  }

  public void setMajorId(Integer majorId) {
    this.majorId = majorId;
  }

  public Integer getMajorId() {
    return this.majorId;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public int getRole() {
    return UserRole.STUDENT.getCode();
  }

  @Override
  public String toString() {
    return "Student{" +
        "id='" + id + '\'' +
        "name='" + name + '\'' +
        "sex='" + sex + '\'' +
        "majorId='" + majorId + '\'' +
        "email='" + email + '\'' +
        "userId='" + userId + '\'' +
        "avatar='" + avatar + '\'' +
        "code='" + code + '\'' +
        "createTime='" + createTime + '\'' +
        "updateTime='" + updateTime + '\'' +
        '}';
  }


}
