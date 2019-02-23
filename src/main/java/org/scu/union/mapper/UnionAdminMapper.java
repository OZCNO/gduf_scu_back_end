package org.scu.union.mapper;

import org.apache.ibatis.annotations.Param;
import org.scu.union.entity.UnionAdmin;

/**
 * Created by lynn on 2019/2/20
 */
public interface UnionAdminMapper {

  UnionAdmin getByUserId(@Param("userId") long userId);

}
