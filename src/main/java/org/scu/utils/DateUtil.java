package org.scu.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lamm on 2018/12/19.
 */
public class DateUtil {

  public static Date addDate(Date date, int field, int diff) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(field, diff);
    return c.getTime();
  }

  public static Date addDateByYear(Date date, int year) {
    return addDate(date, Calendar.YEAR, year);
  }

  public static Date addDateByMonth(Date date, int month) {
    return addDate(date, Calendar.MONTH, month);
  }

  public static Date addDateByDay(Date date, int day) {
    return addDate(date, Calendar.DATE, day);
  }

  public static Date addDateByHour(Date date, int hour) {
    return addDate(date, Calendar.HOUR, hour);
  }

  public static Date addDateByMinute(Date date, int minute) {
    return addDate(date, Calendar.MINUTE, minute);
  }

  public static Date addDateBySecond(Date date, int second) {
    return addDate(date, Calendar.SECOND, second);
  }

  public static Date addDateByMillisecond(Date date, int millisecond) {
    return addDate(date, Calendar.MILLISECOND, millisecond);
  }
}
