package org.scu.student.service;

import java.util.List;
import org.scu.base.service.BaseDBService;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Student;
import org.scu.student.vo.QStudent;

/**
 * Created by lynn on 2019/1/22
 */
public interface StudentService extends BaseDBService<QStudent, Student> {

  List<VVip> listClubVips(QStudent search);
}
