package org.scu.club.entity;

import java.util.Date;

/**
 * @author lamm
 */
public class Club {

  /**
   * 主键 社团编号 isNullAble:0
   */
  private Integer id;

  /**
   * 名称 isNullAble:0
   */
  private String name;

  /**
   * 指导老师编号 isNullAble:0
   */
  private Integer teacherId;

  /**
   * 社团类别 isNullAble:0
   */
  private String clubType;

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

  public void setTeacherId(Integer teacherId) {
    this.teacherId = teacherId;
  }

  public Integer getTeacherId() {
    return this.teacherId;
  }

  public void setClubType(String clubType) {
    this.clubType = clubType;
  }

  public String getClubType() {
    return this.clubType;
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

//  @Override
//  public String toString() {
//    return "Club{" +
//        "id='" + id + '\'' +
//        "name='" + name + '\'' +
//        "teacherId='" + teacherId + '\'' +
//        "clubType='" + clubType + '\'' +
//        "createTime='" + createTime + '\'' +
//        "updateTime='" + updateTime + '\'' +
//        '}';
//  }

}
