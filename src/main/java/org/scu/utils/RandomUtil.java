package org.scu.utils;

import java.util.Random;

/**
 * Created by Lamm on 2018/12/19.
 */
public class RandomUtil {

  public static final String ALL_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  public static String randString(int length){
    Random random = new Random();
    StringBuilder result = new StringBuilder(length);
    for(int i = 0;i < length; i++){
      int number = random.nextInt(ALL_LETTERS.length());
      result.append(ALL_LETTERS.charAt(number));
    }
    return result.toString();
  }
}
