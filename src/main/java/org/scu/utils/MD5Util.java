package org.scu.utils;

import java.security.MessageDigest;

/**
 * Created by Lamm on 2018/12/19.
 */
public class MD5Util {

  private static final String[] HEX_DIGIT_ARRAY = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  public static String encrypt(String str) {
    return encrypt(str, "utf-8");
  }

  public static String encrypt(String str, String charsetname) {
    String encryptStr = null;
    try {
        encryptStr = new String(str);
        MessageDigest md = MessageDigest.getInstance("MD5");
      if (charsetname == null || "".equals(charsetname)) {
        encryptStr = toHexString(md.digest(encryptStr.getBytes()));
      } else {
        encryptStr = toHexString(md.digest(encryptStr.getBytes(charsetname)));
      }
    } catch (Exception exception) {
    }
    return encryptStr;
  }

  private static String toHexString(byte[] b) {
    StringBuffer resultSb = new StringBuffer(512);
    for (int i = 0; i < b.length; i++) {
      resultSb.append(toHex(b[i]));
    }
    return resultSb.toString();
  }

  private static String toHex(byte b) {
    int n = b;
    if (n < 0) {
      n += 256;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return HEX_DIGIT_ARRAY[d1] + HEX_DIGIT_ARRAY[d2];
  }
}