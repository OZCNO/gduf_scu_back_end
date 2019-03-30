package org.scu.club.vo;

import org.scu.club.entity.AnnualRegistration;

/**
 * Created by lamm on 2019/2/24
 */
public class VAnnualRegistration extends AnnualRegistration {

  private String clubName;

  private String teacherName;

  private String teacherMobile;

  private String clubType;

  public String getClubType() {
    return clubType;
  }

  public void setClubType(String clubType) {
    this.clubType = clubType;
  }

  public String getClubName() {
    return clubName;
  }

  public void setClubName(String clubName) {
    this.clubName = clubName;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public String getTeacherMobile() {
    return teacherMobile;
  }

  public void setTeacherMobile(String teacherMobile) {
    this.teacherMobile = teacherMobile;
  }
}
