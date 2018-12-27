package org.scu.base.mapper;

import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface BaseMapper<Q, E> {

  List<E> list(Q search);

  long count(Q search);

  int insert(E item);

  int update(E item);

  int removeById(long id);

  E getById(long id);
}
