package org.scu.base.conf;

/**
 * status code which will return to caller
 * Created by Lamm on 2018/12/19.
 */
public class StatusCode {

  /**
   * 0 means execute successfully in current session
   */
  public static final String SUCCESS = "200";

  /**
   * 500 means throw exception which hasn't bean catch in current session
   */
  public static final String ERROR = "500";

  /**
   * -1 means execute fail in current session
   */
  public static final String FAIL = "0";

  /**
   * 404 means the resource not found in current session
   */
  public static final String NOT_FOUND = "404";

  /**
   * 400 means the request parameter is wrong in current session
   */
  public static final String BAD_REQUEST = "400";

  /**
   * 403 means the user action is illegal in current session
   */
  public static final String FORBIDDEN = "403";

  /**
   * 401 means the user's token is expire in current session
   */
  public static final String SESSION_EXPIRE = "401";
}
