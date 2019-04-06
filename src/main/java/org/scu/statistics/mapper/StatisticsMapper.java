package org.scu.statistics.mapper;

import java.util.List;
import java.util.Map;
import org.scu.statistics.entity.TermActivityStatistics;

/**
 * Created by lamm on 2019/3/30
 */
public interface StatisticsMapper {

  List<TermActivityStatistics> listClubTermActivityStatistics(Map param);

  List<TermActivityStatistics> listUnionTermActivityStatistics(Map param);
}
