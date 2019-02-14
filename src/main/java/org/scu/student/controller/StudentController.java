package org.scu.student.controller;

import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.student.entity.Student;
import org.scu.student.service.StudentService;
import org.scu.student.vo.QRegStudent;
import org.scu.user.entity.User;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.service.UserLoginTokenService;
import org.scu.user.vo.LoginCredential;
import org.scu.user.vo.LoginResult;
import org.scu.user.vo.LoginUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lynn on 2019/1/31
 */
@RestController
public class StudentController extends BaseController {

  @Autowired
  private StudentService studentService;
  
  @Autowired
  private UserLoginTokenService userLoginTokenService;

  @PostMapping("/reg")
  public BaseResponse reg(@RequestBody QRegStudent qRegStudent) {
    User user = studentService.insertStudentUser(qRegStudent);
    // generate user login token
    UserLoginToken loginToken = new UserLoginToken();
    loginToken.setUserId(user.getId());
    loginToken.initDate();
    loginToken.setToken(userLoginTokenService.generateToken());
    userLoginTokenService.save(loginToken);
    LoginResult loginResult = new LoginResult();
    loginResult.setCredential(new LoginCredential(user.getId(), loginToken.getToken()));
    loginResult.setUser(new LoginUserInfo(user));
    return response(loginResult);
  }
}
