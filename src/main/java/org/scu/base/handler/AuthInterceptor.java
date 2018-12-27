package org.scu.base.handler;

import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.service.UserLoginTokenService;
import org.scu.user.vo.QUserLoginToken;
import org.scu.utils.JsonUtil;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * auth interceptor which will check whether the endpoint user's token is legal
 */
@Component
public class AuthInterceptor extends BaseController implements HandlerInterceptor {

    public static final String AUTHORIZATION = "Authorization";

    public static final String BEARER = "Bearer";

    @Autowired
    private UserLoginTokenService userLoginTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }

        String val = request.getHeader(AUTHORIZATION);
        if (val != null && val.startsWith(BEARER)) {
            String[] array = val.split(" ");
            if (array.length >= 3) {
                if (BEARER.equals(array[0])) {
                    try {
                        long userId = Long.parseLong(array[1]);
                        String token = array[2];
                        QUserLoginToken search = new QUserLoginToken();
                        search.setUserId(userId);
                        search.setToken(token);
                        List<UserLoginToken> tokenList = userLoginTokenService.list(search);
                        if (tokenList.size() > 0) {
                            UserLoginToken first = tokenList.get(0);
                            if (first.getExpireDate().after(new Date())) {
                                setLoginUserId(request, userId);
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        logger.error("query user login token[authorization={}] error", val, e);
                    }
                }
            }
        }

        BaseResponse resp = new BaseResponse(StatusCode.SESSION_EXPIRE, "登录超时，请重新登录");
        httpServletResponse.setContentType("application/json;charset=UTF-8");

        PrintWriter writer = httpServletResponse.getWriter();
        String result = JsonUtil.toJson(resp);
        writer.write(result);
        writer.flush();
        writer.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}