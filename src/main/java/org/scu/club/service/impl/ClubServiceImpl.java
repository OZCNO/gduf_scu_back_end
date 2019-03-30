package org.scu.club.service.impl;

import java.util.List;
import org.scu.club.entity.Club;
import org.scu.club.mapper.ClubMapper;
import org.scu.club.service.ClubService;
import org.scu.club.vo.QClub;
import org.scu.club.vo.VClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/1/22
 */
@Service
public class ClubServiceImpl implements ClubService {

  @Autowired
  private ClubMapper clubMapper;

  @Override
  public List<VClub> listClubs(QClub search) {
    return clubMapper.listClubs(search);
  }

  @Override
  @Deprecated
  public List<Club> list(QClub search) {
    return null;
  }

  @Override
  public long count(QClub search) {
    return 0;
  }

  @Override
  public int insert(Club item) {
    return 0;
  }

  @Override
  public int update(Club item) {
    return 0;
  }

  @Override
  public int removeById(long id) {
    return 0;
  }

  @Override
  public Club getById(long id) {
    return null;
  }

  @Override
  public int RecruitVips(Integer clubId, Integer studentId) {
    return clubMapper.updateVipStatus(clubId, studentId);
  }
}
