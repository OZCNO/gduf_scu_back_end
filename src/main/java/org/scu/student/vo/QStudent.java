package org.scu.student.vo;

import org.scu.base.vo.Pagination;

/**
 * Created by lynn on 2019/1/22
 */
public class QStudent extends Pagination {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
