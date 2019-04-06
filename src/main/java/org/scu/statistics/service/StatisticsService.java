package org.scu.statistics.service;

import java.util.List;
import org.scu.statistics.entity.TermActivityStatistics;

/**
 * Created by lamm on 2019/3/30
 */
public interface StatisticsService {

  List<TermActivityStatistics> listClubTermActivityStatistics();

  List<TermActivityStatistics> listUnionTermActivityStatistics();
}
