package org.scu.club.controller;

import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lamm on 2019/1/21
 */
@RestController
public class ActivityController extends BaseController {

  /**
   * 获取社团活动列表
   * @param name
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping(value = "/association/activity")
  public BaseResponse listActivities(@RequestParam(required = false) String name,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {

    return null;
  }

  /**
   * 发布活动
   * @return
   */
  @PostMapping("/association/activity")
  public BaseResponse addActivityInfo() {
    return null;
  }
}
