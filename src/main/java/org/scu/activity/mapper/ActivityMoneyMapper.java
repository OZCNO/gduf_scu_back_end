package org.scu.activity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.activity.entity.Money;

/**
 * Created by lamm on 2019/3/30
 */
public interface ActivityMoneyMapper {

  int insertActivityMoneyUse(List<Money> moneys);

  List<Money> listMoneyUse(@Param("clubOrUnionId") Integer clubOrUnionId,
      @Param("activityType") Integer activityType);
}
