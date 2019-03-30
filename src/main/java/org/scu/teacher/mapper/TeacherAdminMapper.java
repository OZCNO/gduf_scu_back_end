package org.scu.teacher.mapper;

import org.apache.ibatis.annotations.Param;
import org.scu.teacher.entity.TeacherAdmin;

/**
 * Created by lamm on 2019/2/20
 */
public interface TeacherAdminMapper {

  TeacherAdmin getByUserId(@Param("userId") long userId);
}
