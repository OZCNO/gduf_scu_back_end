package org.scu.log.controller;

import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.log.entity.OpLog;
import org.scu.log.vo.QOpLog;
import org.scu.log.service.OpLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lamm on 2018/12/19.
 */
@RestController
public class OpLogController extends BaseController {

  @Autowired
  private OpLogService opLogService;

  @GetMapping(value = "/user/log")
  public BaseResponse list(@RequestParam(required = false) String module,
                           @RequestParam(required = false) Long userId,
                           @RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                           HttpServletRequest request) {

    Long loginUserId = getLoginUserId(request);
    if (!isAdmin(request)) {
      userId = loginUserId;
    }
    QOpLog search = new QOpLog();
    search.setModule(module);
    search.setCurrentUserId(userId);
    search.setPage(page);
    search.setPageSize(pageSize);
    List<OpLog> list = opLogService.list(search);
    long totalCount = opLogService.count(search);
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }
}
