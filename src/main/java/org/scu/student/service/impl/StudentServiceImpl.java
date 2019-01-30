package org.scu.student.service.impl;

import java.util.List;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Student;
import org.scu.student.mapper.StudentMapper;
import org.scu.student.service.StudentService;
import org.scu.student.vo.QStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2019/1/22
 */
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentMapper studentMapper;

  @Override
  public List<VVip> listClubVips(QStudent search) {
    return studentMapper.listClubVips(search);
  }

  @Override
  public Integer countClubVips(QStudent search) {
    return studentMapper.countClubVips(search);
  }

  @Override
  public List<Student> list(QStudent search) {
    return null;
  }

  @Override
  public long count(QStudent search) {
    return 0;
  }

  @Override
  public int insert(Student item) {
    return 0;
  }

  @Override
  public int update(Student item) {
    return 0;
  }

  @Override
  public int removeById(long id) {
    return 0;
  }

  @Override
  public Student getById(long id) {
    return null;
  }
}
