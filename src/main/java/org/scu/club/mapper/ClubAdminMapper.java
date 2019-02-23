package org.scu.club.mapper;

import org.apache.ibatis.annotations.Param;
import org.scu.club.entity.ClubAdmin;

/**
 * Created by lynn on 2019/2/20
 */
public interface ClubAdminMapper {

  ClubAdmin getByUserId(@Param("userId") long userId);
}
