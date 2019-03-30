package org.scu.student.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.base.mapper.BaseMapper;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Recruit;
import org.scu.student.entity.Student;
import org.scu.student.vo.QStudent;

/**
 * Created by lamm on 2019/1/22
 */
public interface StudentMapper extends BaseMapper<QStudent, Student> {

  List<VVip> listClubVips(QStudent search);

  Integer countClubVips(QStudent search);

  Student getByUserId(@Param("userId") long userId);

  int joinActivity(Recruit item);

  int joinClub(Recruit item);
}
