package org.scu.log.service.impl;

import org.scu.log.entity.OpLog;
import org.scu.log.mapper.OpLogMapper;
import org.scu.log.service.OpLogService;
import org.scu.log.vo.QOpLog;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lamm on 2018/12/19.
 */
@Service
public class OpLogServiceImpl implements OpLogService {

  @Autowired
  private OpLogMapper mapper;

  @Override
  public int insert(OpLog item) {
    return mapper.insert(item);
  }

  @Override
  public List<OpLog> list(QOpLog search) {
    return mapper.list(search);
  }

  @Override
  public long count(QOpLog search) {
    return mapper.count(search);
  }
}
