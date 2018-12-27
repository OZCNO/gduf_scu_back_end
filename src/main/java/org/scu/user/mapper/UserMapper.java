package org.scu.user.mapper;

import org.scu.base.mapper.BaseMapper;
import org.scu.user.entity.User;
import org.scu.user.vo.QUser;
import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public interface UserMapper extends BaseMapper<QUser, User> {

  List<User> getAll(QUser user);
}
