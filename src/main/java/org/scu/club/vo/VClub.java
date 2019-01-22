package org.scu.club.vo;

import org.scu.club.entity.Club;

/**
 * Created by lynn on 2019/1/22
 */
public class VClub extends Club {

  private String teacherName;

  private String clubTypeName;

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  @Override
  public String getClubType() {
    return clubTypeName;
  }

  @Override
  public void setClubType(String clubTypeName) {
    this.clubTypeName = clubTypeName;
  }
}
