package org.scu.log.vo;

import org.scu.base.vo.AuthSearch;
import org.scu.base.conf.LogConstants;
import org.springframework.util.StringUtils;

/**
 * Created by Lamm on 2018/12/19.
 */
public class QOpLog extends AuthSearch {

  private String module;

  private String action;

  public String getModule() {
    return module;
  }

  public void setModule(String module) {
    if (!StringUtils.isEmpty(module)) {
      String[] array = module.split(LogConstants.SPLITOR_MODULE_ACTION);
      this.module = array[0];
      if (array.length > 1) {
        this.action = array[1];
      }
    }
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }
}
