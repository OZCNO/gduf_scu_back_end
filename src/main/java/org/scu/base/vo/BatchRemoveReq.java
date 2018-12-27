package org.scu.base.vo;

import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public class BatchRemoveReq {

  private List<Long> ids;

  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
  }
}
