package org.scu.club.service;

import java.util.List;
import org.scu.base.service.BaseDBService;
import org.scu.club.entity.Club;
import org.scu.club.vo.QClub;
import org.scu.club.vo.VClub;

/**
 * Created by lamm on 2019/1/22
 */
public interface ClubService extends BaseDBService<QClub, Club>{

  List<VClub> listClubs(QClub search);

  int RecruitVips(Integer clubId, Integer studentId);
}
