package org.scu.base.handler;

import org.scu.base.controller.BaseController;
import org.scu.utils.IPUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * url interceptor which will record the controller call info
 */
@Component
public class UrlInterceptor extends BaseController implements HandlerInterceptor {

    private ThreadLocal<Long> timeHolder = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        timeHolder.set(System.currentTimeMillis());
        String ip = IPUtil.getIPAddress(request);
        String url = request.getRequestURL().toString();
        logger.debug("url:{}, ip:{}, begin to execute", url, ip);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String ip = IPUtil.getIPAddress(request);
        String url = request.getRequestURL().toString();
        Long startTime = timeHolder.get();
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        logger.debug("url:{}, ip:{}, execute success, cost time: {}ms", url, ip, diff);
        timeHolder.remove();
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}