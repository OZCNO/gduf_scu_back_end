package org.scu.student.entity;

import java.util.Date;

/**
 * @author lamm
 */
public class Student {

  /**
   * 主键 编号 isNullAble:0
   */
  private Integer id;

  /**
   * 姓名 isNullAble:0
   */
  private String name;

  /**
   * 性别 isNullAble:0
   */
  private String sex;

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
   * isNullAble:0
   */
  private Integer userId;

  /**
   * 头像 isNullAble:0
   */
  private String avatar;

  /**
   * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
   */
  private Date createTime;

  /**
   * isNullAble:0,defaultVal:0000-00-00 00:00:00
   */
  private Date updateTime;


  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSex() {
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

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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
