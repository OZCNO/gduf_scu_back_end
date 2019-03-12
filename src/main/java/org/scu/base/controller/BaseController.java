package org.scu.base.controller;

import org.scu.auth.conf.Role;
import org.scu.auth.service.UserDataAuthService;
import org.scu.auth.vo.QUserDataAuth;
import org.scu.auth.vo.QUserMultiDataAuth;
import org.scu.base.conf.StatusCode;
import org.scu.base.conf.TargetType;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.scu.user.service.UserService;
import org.scu.base.conf.ResponseMsg;
import org.scu.base.conf.ResponseMsg.Query;
import org.scu.base.domain.BaseResponse;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lamm on 2018/12/19.
 */
public class BaseController {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  protected final String USER_KEY = "loginUser";

  protected final BaseResponse FORBIDDEN =
    new BaseResponse(StatusCode.FORBIDDEN, ResponseMsg.FORBIDDEN);

  @Autowired
  protected UserDataAuthService userDataAuthService;

  @Autowired
  private UserService userSerivce;

  public Long getLoginUserId(HttpServletRequest request) {
    Object userId = request.getAttribute(USER_KEY);
    if (userId == null) {
      return null;
    }
    return (Long) userId;
  }

  public void setLoginUserId(HttpServletRequest request, Long userId) {
    request.setAttribute(USER_KEY, userId);
  }

  public User getLoginUser(HttpServletRequest request) {
    Long id = getLoginUserId(request);
    User user = userSerivce.getById(id);
    return user;
  }

  public RoleInfo getUserRoleInfo(User user) {
    return userSerivce.getRoleInfo(user);
  }

  public BaseResponse response(Object data) {
    BaseResponse resp = new BaseResponse();
    if (data != null) {
      resp.setCode(StatusCode.SUCCESS);
      resp.setMsg(Query.SUCCESS);
      resp.setData(data);
    } else {
      resp.setCode(StatusCode.NOT_FOUND);
      resp.setMsg(ResponseMsg.NOT_FOUND);
    }
    return resp;
  }

  public BaseResponse response(int status, Object data) {
    BaseResponse resp = new BaseResponse();
    if (status > 0) {
      resp.setCode(StatusCode.SUCCESS);
      resp.setMsg(ResponseMsg.SUCCESS);
      resp.setData(data);
    } else {
      resp.setMsg(ResponseMsg.FAIL);
      resp.setCode(StatusCode.FAIL);
    }
    return resp;
  }

//  public boolean canRead(HttpServletRequest request, TargetType targetType, Long targetId) {
//    User user = getLoginUser(request);
//    if (UserRole.UNION_ADMIN.getCode().equals(user.getRole())) {
//      return true;
//    }
//    Long currentUserId = getLoginUserId(request);
//    QUserDataAuth authSearch = new QUserDataAuth();
//    authSearch.setUserId(currentUserId);
//    authSearch.setTargetType(targetType.getType());
//    authSearch.setTargetId(targetId);
//    boolean flag = userDataAuthService.canRead(authSearch);
//    return flag;
//  }
//
//  public boolean canWrite(HttpServletRequest request, TargetType targetType, Long targetId) {
//    User user = getLoginUser(request);
//    if (UserRole.UNION_ADMIN.getCode().equals(user.getRole())) {
//      return true;
//    }
//    Long currentUserId = getLoginUserId(request);
//    QUserDataAuth authSearch = new QUserDataAuth();
//    authSearch.setUserId(currentUserId);
//    authSearch.setTargetType(targetType.getType());
//    authSearch.setTargetId(targetId);
//    boolean flag = userDataAuthService.canWrite(authSearch);
//    return flag;
//  }
//
//  public List<Long> filterIds(HttpServletRequest request,
//                              TargetType targetType,
//                              List<Long> ids,
//                              Role role) {
//    User user = getLoginUser(request);
//    if (UserRole.UNION_ADMIN.getCode().equals(user.getRole())) {
//      return ids;
//    }
//    Long userId = user.getId();
//    QUserMultiDataAuth search = new QUserMultiDataAuth();
//    search.setRole(role.getType());
//    search.setTargetIds(ids);
//    search.setTargetType(targetType.getType());
//    search.setUserId(userId);
//    List<Long> newIds = userDataAuthService.filterIds(search);
//    return newIds;
//  }

  public boolean isAdmin(HttpServletRequest request) {
    User user = getLoginUser(request);
    if (UserRole.UNION_ADMIN.getCode().equals(user.getRole())) {
      return true;
    }
    return false;
  }
}
