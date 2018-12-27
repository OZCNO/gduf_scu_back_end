package org.scu.user.entity;

import org.scu.user.conf.UserConf;
import org.scu.utils.DateUtil;
import java.util.Date;

/**
 * Created by Lamm on 2018/12/19.
 */
public class UserLoginToken {

  private Long id;

  private Long userId;

  private String token;

  private Date createTime;

  private Date updateTime;

  private Date expireDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }

  public void initDate() {
    Date current = new Date();
    if (getCreateTime() == null) {
      this.createTime = current;
    }
    this.updateTime = current;
    this.expireDate = DateUtil.addDateByMonth(current, UserConf.DEFAULT_USER_LOGIN_TOKEN_EXPIRE_MONTH);
  }
}
