package org.scu.statistics.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.scu.statistics.entity.TermActivityStatistics;
import org.scu.statistics.mapper.StatisticsMapper;
import org.scu.statistics.service.StatisticsService;
import org.scu.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lamm on 2019/3/30
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

  @Autowired
  private StatisticsMapper statisticsMapper;

  @Override
  public List<TermActivityStatistics> listClubTermActivityStatistics() {
    Map param = handleTermDate();
    return statisticsMapper.listClubTermActivityStatistics(param);
  }

  @Override
  public List<TermActivityStatistics> listUnionTermActivityStatistics() {
    Map param = handleTermDate();
    return statisticsMapper.listUnionTermActivityStatistics(param);
  }

  private Map handleTermDate() {
    LocalDate current = LocalDate.now();
    LocalDate beginDate = LocalDate.of(current.getYear(), 2,16);
    LocalDate endDate = LocalDate.of(current.getYear(), 8,14);
    boolean flag =  DateUtil.belongCalendar(current, beginDate, endDate);
    Map<String, Object> map = new HashMap<>();
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime beginZdt, endZdt;
    if (!flag) {
      if (current.isAfter(endDate)) {
        beginDate = LocalDate.of(current.getYear(), 8,15);
        endDate = LocalDate.of(current.getYear() + 1, 2,15);
      } else {
        beginDate = LocalDate.of(current.getYear() - 1, 8,15);
        endDate = LocalDate.of(current.getYear(), 2,15);
      }
    }
    beginZdt = beginDate.atStartOfDay(zoneId);
    endZdt = endDate.atStartOfDay(zoneId);
//    System.out.println("++++++++++++++++");
//    System.out.println(beginDate);
//    System.out.println(endDate);
    map.put("beginDate", Date.from(beginZdt.toInstant()));
    map.put("endDate", Date.from(endZdt.toInstant()));
//    System.out.println(map.get("beginDate"));
//    System.out.println(map.get("endDate"));
    return map;
  }
}
