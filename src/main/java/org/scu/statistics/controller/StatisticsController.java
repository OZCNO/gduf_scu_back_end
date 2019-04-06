package org.scu.statistics.controller;

import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.statistics.entity.TermActivityStatistics;
import org.scu.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lamm on 2019/3/30
 */
@RestController
public class StatisticsController extends BaseController {

  @Autowired
  private StatisticsService statisticsService;

  // 获取所有社联社团本学期活动统计情况
  @GetMapping("/{type}/term/activity/statistics")
  public BaseResponse listClubTermActivityStatistics(@PathVariable("type") String type) {
    List<TermActivityStatistics> list;
    if (type.equalsIgnoreCase("club")) {
      list = statisticsService.listClubTermActivityStatistics();
    } else if (type.equalsIgnoreCase("union")) {
      list = statisticsService.listUnionTermActivityStatistics();
    } else {
      return FORBIDDEN;
    }

    return response(list);
  }


  // 获取活动统计情况
  // 获取社团活动热度指数
}
