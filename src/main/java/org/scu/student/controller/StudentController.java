package org.scu.student.controller;

import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.student.entity.Recruit;
import org.scu.student.entity.Student;
import org.scu.student.service.StudentService;
import org.scu.student.vo.QRegStudent;
import org.scu.student.vo.QStudent;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.service.UserLoginTokenService;
import org.scu.user.service.UserService;
import org.scu.user.vo.LoginCredential;
import org.scu.user.vo.LoginResult;
import org.scu.user.vo.LoginUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private UserService userService;

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

  @ApiOperation(value = "学生参加活动", notes = "学生参加活动", httpMethod = "POST")
  @PostMapping("/student/{studentId}/activity/{activityId}")
  public BaseResponse joinActivity(@PathVariable("studentId") Integer studentId,
      @PathVariable("activityId") Integer activityId,
      @RequestBody(required = false) Recruit recruit,
      HttpServletRequest request) {
    User loginUser = getLoginUser(request);
    if (!loginUser.getRole().equals(UserRole.STUDENT.getCode())) {
      return FORBIDDEN;
    }
    RoleInfo roleInfo = getUserRoleInfo(loginUser);
    if (roleInfo != null) {
      if (roleInfo instanceof Student) {
        Student student = (Student) roleInfo;
        if(!student.getId().equals(studentId)) {
          return FORBIDDEN;
        }
      }
    }
    System.out.println("=====================3");
    Recruit item = recruit == null ? new Recruit() : recruit;
    item.setActivityId(activityId);
    item.setStudentId(studentId);
    int result = studentService.joinActivity(item);
    return response(result, null);
  }
}
