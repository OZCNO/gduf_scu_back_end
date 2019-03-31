package org.scu.activity.vo;

import java.util.List;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;

/**
 * Created by lamm on 2019/1/23
 */
public class VActivity extends Activity {

  private String clubOrUnionName;

  public String getClubOrUnionName() {
    return clubOrUnionName;
  }

  public void setClubOrUnionName(String clubOrUnionName) {
    this.clubOrUnionName = clubOrUnionName;
  }

  private List<Money> moneyUse;

  public List<Money> getMoneyUse() {
    return moneyUse;
  }

  public void setMoneyUse(List<Money> moneyUse) {
    this.moneyUse = moneyUse;
  }
}
