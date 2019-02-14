package org.scu.club.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/26
 */
public class QAnnualRegistration extends Pagination {

//  private String name;

  private int status;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
