package org.scu.club.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.base.service.BaseDBService;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Student;
import org.scu.student.vo.QStudent;

/**
 * Created by lamm on 2019/1/23
 */
public interface VipService extends BaseDBService<QStudent, Student> {

  List<VVip> listClubVips(QStudent search);
}
