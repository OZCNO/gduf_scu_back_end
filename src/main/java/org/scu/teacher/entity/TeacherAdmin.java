package org.scu.teacher.entity;

import org.scu.user.conf.UserRole;
import org.scu.user.entity.RoleInfo;
import org.scu.user.entity.User;

/**
 * Created by lamm on 2019/1/21
 */
public class TeacherAdmin extends RoleInfo {

  @Override
  public int getRole() {
    return UserRole.TEACHER_ADMIN.getCode();
  }
}
