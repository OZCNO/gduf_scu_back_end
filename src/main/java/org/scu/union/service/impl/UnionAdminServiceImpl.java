package org.scu.union.service.impl;

import org.scu.union.entity.UnionAdmin;
import org.scu.union.mapper.UnionAdminMapper;
import org.scu.union.service.UnionAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lynn on 2019/2/23
 */
@Service
public class UnionAdminServiceImpl implements UnionAdminService {

  @Autowired
  private UnionAdminMapper unionAdminMapper;

  @Override
  public UnionAdmin getByUserId(long userId) {
    return unionAdminMapper.getByUserId(userId);
  }
}
