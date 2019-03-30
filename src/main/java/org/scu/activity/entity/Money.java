package org.scu.activity.entity;

import java.util.Date;

/**
 * 经费
 * Created by lamm on 2019/3/30
 */
public class Money {

  private Integer id;

  private Integer activity_id;

  private String use;

  private Double sum;

  private Date create_time;

  private Date update_time;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getActivity_id() {
    return activity_id;
  }

  public void setActivity_id(Integer activity_id) {
    this.activity_id = activity_id;
  }

  public String getUse() {
    return use;
  }

  public void setUse(String use) {
    this.use = use;
  }

  public Double getSum() {
    return sum;
  }

  public void setSum(Double sum) {
    this.sum = sum;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }

  public Date getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(Date update_time) {
    this.update_time = update_time;
  }
}
