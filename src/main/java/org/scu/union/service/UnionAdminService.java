package org.scu.union.service;

import org.scu.union.entity.UnionAdmin;

/**
 * Created by lynn on 2019/2/23
 */
public interface UnionAdminService {

  UnionAdmin getByUserId(long userId);
}