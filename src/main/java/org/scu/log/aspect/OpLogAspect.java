package org.scu.log.aspect;

import org.scu.base.controller.BaseController;
import org.scu.user.vo.ModifyPasswordReq;
import org.scu.user.vo.QUser;
import org.scu.utils.IPUtil;
import org.scu.utils.JsonUtil;
import org.scu.log.annotation.Log;
import org.scu.log.entity.OpLog;
import org.scu.log.service.OpLogService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * save the user op log which just save the non-get operation
 * Created by Lamm on 2018/12/19.
 */
@Aspect
@Component
public class OpLogAspect extends BaseController {

    private ThreadLocal<OpLog> opLogThreadLocal = new ThreadLocal<>();

    public static final String DEFAULT_SENSITIVE_STRING = "******";

    @Autowired
    private OpLogService opLogService;

    @Before("@annotation(log)")
    public void doBefore(JoinPoint joinPoint, Log log){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (RequestMethod.GET.toString().equalsIgnoreCase(request.getMethod())) {
            return;
        }
        OpLog opLog = new OpLog();
        Object[] params = joinPoint.getArgs();
        opLog.setRequestData(params2String(params));
        opLogThreadLocal.set(opLog);
    }

    @AfterReturning(pointcut = "@annotation(log)",returning = "result")
    public void doAfterReturing(Object result, Log log){
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            if (RequestMethod.GET.toString().equalsIgnoreCase(request.getMethod())) {
                return;
            }
            Date current = new Date();
            OpLog opLog =opLogThreadLocal.get();
            String url = request.getRequestURL().toString();
            opLog.setCreateTime(current);
            opLog.setUpdateTime(current);
            opLog.setUrl(url);
            opLog.setIp(IPUtil.getIPAddress(request));
            opLog.setAction(log.action());
            opLog.setModule(log.module());
            opLog.setUserId(getLoginUserId(request));
            opLog.setResponseData(toJson(result));
            opLogService.insert(opLog);
        } catch (Exception e) {
            logger.error("log aspect after returning error:", e);
            opLogThreadLocal.remove();
        }
    }

    public String params2String(Object[] params) {
        StringBuilder content = new StringBuilder(512);
        for (Object item : params) {
            String str = toJson(item);
            content.append(str);
            content.append(" || ");
        }
        return content.toString();
    }

    public String toJson(Object item) {
        Object instance = item;
        if (item == null || item instanceof HttpServletRequest || item instanceof HttpServletResponse) {
            return "";
        }
        if (instance instanceof ModifyPasswordReq) {
            ModifyPasswordReq newObj = new ModifyPasswordReq();
            BeanUtils.copyProperties(item, newObj);
            if (!StringUtils.isEmpty(newObj.getOldPass())) {
                newObj.setOldPass(DEFAULT_SENSITIVE_STRING);
            }
            if (!StringUtils.isEmpty(newObj.getNewPass())) {
                newObj.setNewPass(DEFAULT_SENSITIVE_STRING);
            }
            instance = newObj;
        } else if (instance instanceof QUser) {
            QUser newObj = new QUser();
            BeanUtils.copyProperties(item, newObj);
            if (!StringUtils.isEmpty(newObj.getPassword())) {
                newObj.setPassword(DEFAULT_SENSITIVE_STRING);
            }
            instance = newObj;
        }
        return JsonUtil.toJson(instance);
    }
}