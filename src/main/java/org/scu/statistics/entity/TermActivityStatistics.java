package org.scu.statistics.entity;

/**
 * Created by lamm on 2019/4/6
 */
public class TermActivityStatistics {

  private Integer id;

  private String name;

  private Integer times;

  private Integer memberTimes;

  private Integer unmemberTimes;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTimes() {
    return times;
  }

  public void setTimes(Integer times) {
    this.times = times;
  }

  public Integer getMemberTimes() {
    return memberTimes;
  }

  public void setMemberTimes(Integer memberTimes) {
    this.memberTimes = memberTimes;
  }

  public Integer getUnmemberTimes() {
    return unmemberTimes;
  }

  public void setUnmemberTimes(Integer unmemberTimes) {
    this.unmemberTimes = unmemberTimes;
  }
}
