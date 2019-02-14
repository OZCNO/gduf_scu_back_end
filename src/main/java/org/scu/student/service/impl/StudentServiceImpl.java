package org.scu.student.service.impl;

import java.util.Date;
import java.util.List;
import org.scu.club.vo.VVip;
import org.scu.student.entity.Student;
import org.scu.student.mapper.StudentMapper;
import org.scu.student.service.StudentService;
import org.scu.student.vo.QRegStudent;
import org.scu.student.vo.QStudent;
import org.scu.user.conf.UserConf;
import org.scu.user.conf.UserRole;
import org.scu.user.entity.User;
import org.scu.user.mapper.UserMapper;
import org.scu.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Created by lynn on 2019/1/22
 */
@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentMapper studentMapper;

  @Autowired
  private UserMapper userMapper;

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
    return studentMapper.insert(item);
  }

  @Override
  @Transactional
  public User insertStudentUser(QRegStudent item) {
    User user = new User();
    user.setUsername(item.getUsername());
    user.setPassword(item.getPassword());
    if (!StringUtils.isEmpty(item.getPassword())) {
      String encryptPass = encryptPass(item.getPassword());
      user.setPassword(encryptPass);
    }
    user.setRole(UserRole.STUDENT.getCode());
    userMapper.insert(user);
    Student student = new Student();
    Date current = new Date();
    student.setName("");
    student.setMobile("");
    student.setCreateTime(current);
    student.setUpdateTime(current);
    student.setAvatar("");
    student.setCode("");
    student.setEmail("");
    student.setMajorId(-1);
    student.setSex("");
    student.setUserId(user.getId().intValue());
    studentMapper.insert(student);
    return user;
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

  public String encryptPass(String password) {
    String encryptPass = MD5Util.encrypt(UserConf.DEFAULT_ENCRYPT_PREFIX_SALT + password + UserConf.DEFAULT_ENCRYPT_SUFFIXSALT);
    return encryptPass;
  }
}
