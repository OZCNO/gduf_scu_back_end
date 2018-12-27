package org.scu.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lamm on 2018/12/19.
 */
public class IPUtil {

  public static String getIPAddress(HttpServletRequest request) {
    String ip = null;

    // squid service agent
    String ipAddresses = request.getHeader("X-Forwarded-For");

    // apache service agent
    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
      ipAddresses = request.getHeader("Proxy-Client-IP");
    }

    // weblogic service agent
    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
      ipAddresses = request.getHeader("WL-Proxy-Client-IP");
    }

    // agent server
    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
      ipAddresses = request.getHeader("HTTP_CLIENT_IP");
    }

    // nginx service agent
    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
      ipAddresses = request.getHeader("X-Real-IP");
    }

    // maybe more than one
    if (ipAddresses != null && ipAddresses.length() != 0) {
      ip = ipAddresses.split(",")[0];
    }

    // default
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
}
