package org.scu.user.controller;

import org.scu.auth.conf.Role;
import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.club.entity.ClubAdmin;
import org.scu.student.entity.Student;
import org.scu.teacher.entity.TeacherAdmin;
import org.scu.union.entity.UnionAdmin;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;
import org.scu.user.service.UserService;
import org.scu.user.vo.ModifyPasswordReq;
import org.scu.base.conf.LogConstants;
import org.scu.log.annotation.Log;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2018/12/19.
 */
@RestController
public class UserController extends BaseController {

  @Autowired
  private UserService userService;

//  @Log(module = LogConstants.User.MODULE, action = LogConstants.User.ACTION_MODIFY_PASSWORD)
  @PutMapping("/user/password")
  public BaseResponse modifyPass(@RequestBody ModifyPasswordReq req,  HttpServletRequest request) {
    User loginUser = getLoginUser(request);
    BaseResponse resp = new BaseResponse();
    boolean flag = userService.isCorrectPass(req.getOldPass(), loginUser.getPassword());
    if (flag) {
      String encryptPass = userService.encryptPass(req.getNewPass());
      loginUser.setPassword(encryptPass);
      userService.update(loginUser);
      resp.setCode(StatusCode.SUCCESS);
      resp.setMsg("密码修改成功");
      return resp;
    } else {
      resp.setCode(StatusCode.FAIL);
      resp.setMsg("旧密码有误");
      return resp;
    }
  }

  @GetMapping("/user/info")
  public BaseResponse getUserInfo(HttpServletRequest request) {
    User loginUser = getLoginUser(request);
    RoleInfo roleInfo = userService.getRoleInfo(loginUser);
    if (roleInfo != null) {
      if (roleInfo instanceof Student) {
        Student student = (Student) roleInfo;
        return response(student);
      } else if (roleInfo instanceof ClubAdmin) {
        ClubAdmin clubAdmin = (ClubAdmin) roleInfo;
        return response(clubAdmin);
      } else if (roleInfo instanceof TeacherAdmin) {
        TeacherAdmin teacherAdmin = (TeacherAdmin)roleInfo;
        return response(teacherAdmin);
      } else if (roleInfo instanceof UnionAdmin) {
        UnionAdmin unionAdmin = (UnionAdmin)roleInfo;
        return response(unionAdmin);
      }
    }
    return response(null);

  }
}
