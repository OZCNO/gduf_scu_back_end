package org.scu.base.controller;

import org.scu.base.conf.StatusCode;
import org.scu.base.domain.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * handler which catch the global exception except the fail url {@see WrongUrlExceptionHandler} and entity mapping exception
 * Created by Lamm on 2018/12/19.
 */
@ApiIgnore
@RestController
public class WrongUrlExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public BaseResponse error(HttpServletResponse response, HttpServletRequest request) {
        return new BaseResponse(StatusCode.NOT_FOUND, "api url有误");
    }
}