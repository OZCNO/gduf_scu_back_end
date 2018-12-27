package org.scu.base.advice;

import org.scu.base.conf.StatusCode;
import org.scu.base.controller.WrongUrlExceptionHandler;
import org.scu.base.domain.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * handler which catch the global exception except the fail url ({@link WrongUrlExceptionHandler})
 * and entity mapping exception
 * Created by Lamm on 2018/12/19.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public BaseResponse handle(RuntimeException e, HttpServletRequest request, HttpServletResponse response) {
    String url = request.getRequestURL().toString();
    logger.error("user visit url:{} has error:", url, e);
    return new BaseResponse(StatusCode.ERROR, "系统繁忙，请稍后重试");
  }
}
