package org.scu.club.service;

import org.scu.club.entity.ClubAdmin;

/**
 * Created by lamm on 2019/2/23
 */
public interface ClubAdminService {

  ClubAdmin getByUserId(long userId);
}
