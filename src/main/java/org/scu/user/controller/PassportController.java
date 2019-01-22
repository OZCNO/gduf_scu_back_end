package org.scu.user.controller;

import org.scu.base.conf.StatusCode;
import org.scu.user.service.UserService;
import org.scu.base.conf.LogConstants;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.log.annotation.Log;
import org.scu.user.entity.User;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.service.UserLoginTokenService;
import org.scu.user.vo.LoginCredential;
import org.scu.user.vo.LoginResult;
import org.scu.user.vo.LoginUserInfo;
import org.scu.user.vo.QUser;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2018/12/19.
 */
@RestController
public class PassportController extends BaseController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserLoginTokenService userLoginTokenService;

//  @Log(module = LogConstants.User.MODULE, action = LogConstants.User.ACTION_LOGIN)
  @RequestMapping(value = "login", method = RequestMethod.POST)
  public BaseResponse login(@RequestBody QUser user, HttpServletRequest request) {
    // 0. search by user name
    QUser search = new QUser();
    search.setUsername(user.getUsername());
    search.setRole(user.getRole());
    List<User> userList = userService.list(search);

    // 1.check whether exist the match user by name
    if (userList.size() > 0) {
      User first = userList.get(0);

      // 2.check whether the password is right.
      boolean isCorrectPass = userService.isCorrectPass(user.getPassword(), first.getPassword());
      if (isCorrectPass) {

        // 3 generate user login token
        UserLoginToken loginToken = new UserLoginToken();
        loginToken.setUserId(first.getId());
        loginToken.initDate();
        loginToken.setToken(userLoginTokenService.generateToken());
        userLoginTokenService.save(loginToken);

        setLoginUserId(request, first.getId());

        LoginResult loginResult = new LoginResult();
        loginResult.setCredential(new LoginCredential(first.getId(), loginToken.getToken()));
        loginResult.setUser(new LoginUserInfo(first));
        return new BaseResponse(StatusCode.SUCCESS, "登录成功", loginResult);
      } else {
        return new BaseResponse(StatusCode.FAIL, "用户名/密码有误");
      }
    } else {
      return new BaseResponse(StatusCode.FAIL, "用户名/密码有误");
    }
  }
}
