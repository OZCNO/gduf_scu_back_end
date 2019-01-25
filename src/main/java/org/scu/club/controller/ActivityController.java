package org.scu.club.controller;

import java.util.List;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.club.entity.Activity;
import org.scu.club.service.ActivityService;
import org.scu.club.vo.QActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2019/1/21
 */
@RestController
public class ActivityController extends BaseController {

  @Autowired
  private ActivityService activityService;

  /**
   * 获取社团活动列表
   * @param name
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping(value = "/club/activity")
  public BaseResponse listActivities(@RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    QActivity search = new QActivity();
    search.setName(name);
    search.setPage(page);
    search.setPageSize(pageSize);
    List<Activity> list = activityService.list(search);
    PaginationResult paginationResult = new PaginationResult(list);
    return response(paginationResult);
  }

  /**
   * 发布活动
   * @return
   */
  @PostMapping("/club/activity")
  public BaseResponse addActivityInfo() {
    return null;
  }
}
