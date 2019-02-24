package org.scu.club.vo;

import org.scu.club.entity.AnnualRegistration;

/**
 * Created by lynn on 2019/2/24
 */
public class VAnnualRegistration extends AnnualRegistration {

  private String clubName;

  private String teacherName;

  private String teacherMobile;

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
