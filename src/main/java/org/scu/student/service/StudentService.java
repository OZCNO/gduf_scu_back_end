package org.scu.student.service;

import java.util.List;
import org.scu.base.service.BaseDBService;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Student;
import org.scu.student.vo.QRegStudent;
import org.scu.student.vo.QStudent;
import org.scu.user.entity.User;

/**
 * Created by lynn on 2019/1/22
 */
public interface StudentService extends BaseDBService<QStudent, Student> {

  List<VVip> listClubVips(QStudent search);

  Integer countClubVips(QStudent search);

  User insertStudentUser(QRegStudent item);
}
