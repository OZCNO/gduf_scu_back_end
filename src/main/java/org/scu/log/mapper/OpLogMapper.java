package org.scu.log.mapper;

import org.scu.log.entity.OpLog;
import org.scu.log.vo.QOpLog;
import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface OpLogMapper {

  int insert(OpLog item);

  List<OpLog> list(QOpLog search);

  long count(QOpLog search);
}
