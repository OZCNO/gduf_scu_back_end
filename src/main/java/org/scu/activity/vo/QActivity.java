package org.scu.activity.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/23
 */
public class QActivity extends Pagination {

  private String name;

  private int status;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
