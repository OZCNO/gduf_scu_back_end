package org.scu.utils;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Created by Lamm on 2018/12/19.
 */
public class DecimalUtil {

  public static String format(Double val, int fractionDigits) {
    NumberFormat nf = NumberFormat.getPercentInstance();
    nf.setMinimumFractionDigits(fractionDigits);//设置保留小数位
    nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
    return nf.format(val.doubleValue());
  }
}
