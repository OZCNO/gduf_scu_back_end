package org.scu.teacher.service.impl;

import org.scu.teacher.entity.TeacherAdmin;
import org.scu.teacher.mapper.TeacherAdminMapper;
import org.scu.teacher.service.TeacherAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/2/23
 */
@Service
public class TeacherAdminServiceImpl implements TeacherAdminService {

  @Autowired
  private TeacherAdminMapper teacherAdminMapper;

  @Override
  public TeacherAdmin getByUserId(long userId) {
    return teacherAdminMapper.getByUserId(userId);
  }
}
