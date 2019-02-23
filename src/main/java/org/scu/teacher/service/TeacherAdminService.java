package org.scu.teacher.service;

import org.scu.teacher.entity.TeacherAdmin;

/**
 * Created by lynn on 2019/2/23
 */
public interface TeacherAdminService {

  TeacherAdmin getByUserId(long userId);
}
