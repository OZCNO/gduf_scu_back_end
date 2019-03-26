package org.scu.student.vo;

import java.util.Date;
import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/22
 */
public class QStudent extends Pagination {

  private String name;

  private Integer clubId;

  private Integer role;

  // 审核状态
  private Integer status;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public Integer getClubId() {
    return clubId;
  }

  public void setClubId(Integer clubId) {
    this.clubId = clubId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
