package org.scu.user.controller;

import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.user.entity.User;
import org.scu.user.service.UserService;
import org.scu.user.vo.ModifyPasswordReq;
import org.scu.base.conf.LogConstants;
import org.scu.log.annotation.Log;
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
public class UserController extends BaseController {

  @Autowired
  private UserService userService;

//  @Log(module = LogConstants.User.MODULE, action = LogConstants.User.ACTION_MODIFY_PASSWORD)
  @RequestMapping(value = "user/password", method = RequestMethod.POST)
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
}
