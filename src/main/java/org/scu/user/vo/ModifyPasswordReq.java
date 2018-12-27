package org.scu.user.vo;

/**
 * Created by Lamm on 2018/12/19.
 */
public class ModifyPasswordReq {

  private String oldPass;

  private String newPass;

  public String getOldPass() {
    return oldPass;
  }

  public void setOldPass(String oldPass) {
    this.oldPass = oldPass;
  }

  public String getNewPass() {
    return newPass;
  }

  public void setNewPass(String newPass) {
    this.newPass = newPass;
  }
}
