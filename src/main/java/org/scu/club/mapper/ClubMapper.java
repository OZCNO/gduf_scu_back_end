package org.scu.club.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.scu.base.mapper.BaseMapper;
import org.scu.club.entity.Club;
import org.scu.club.vo.QClub;
import org.scu.club.vo.VClub;

/**
*  @author author
*/
public interface ClubMapper extends BaseMapper<QClub, Club> {

  List<VClub> listClubs(QClub search);

  int updateVipStatus(@Param("clubId") Integer clubId, @Param("studentId") Integer studentId);
}