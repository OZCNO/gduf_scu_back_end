package org.scu.user.mapper;

import org.scu.base.mapper.BaseMapper;
import org.scu.user.entity.UserLoginToken;
import org.scu.user.vo.QUserLoginToken;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface UserLoginTokenMapper extends BaseMapper<QUserLoginToken, UserLoginToken>{

  int removeByUserId(long userId);
}
