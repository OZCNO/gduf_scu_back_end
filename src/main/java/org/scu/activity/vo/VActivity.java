package org.scu.activity.vo;

import java.util.List;
import org.scu.activity.entity.Activity;
import org.scu.activity.entity.Money;

/**
 * Created by lynn on 2019/1/23
 */
public class VActivity extends Activity {

  private String clubOrUnionName;

  private List<Money> MoneyUse;

  @Override
  public List<Money> getMoneyUse() {
    return MoneyUse;
  }

  @Override
  public void setMoneyUse(List<Money> moneyUse) {
    MoneyUse = moneyUse;
  }

  public String getClubOrUnionName() {
    return clubOrUnionName;
  }

  public void setClubOrUnionName(String clubOrUnionName) {
    this.clubOrUnionName = clubOrUnionName;
  }
}
