package org.scu.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.entity.Fund;
import org.scu.activity.vo.VFund;

/**
 * Created by lynn on 2019/3/31
 */
public interface FundMapper {

  List<VFund> list(@Param("type") Integer type);

  int update(Fund item);
}
