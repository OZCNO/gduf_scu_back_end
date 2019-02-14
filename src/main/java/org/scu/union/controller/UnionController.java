package org.scu.union.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.scu.activity.conf.AnnualRegStatus;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.base.domain.PaginationResult;
import org.scu.club.entity.AnnualRegistration;
import org.scu.club.service.AnnualRegistrationService;
import org.scu.club.vo.QAnnualRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lynn on 2019/2/14
 */
@RestController
public class UnionController extends BaseController {

  @Autowired
  private AnnualRegistrationService annualRegistrationService;

  @GetMapping("/club/annual/registration")
  @ApiOperation(value = "获取年度注册表列表", notes = "获取年度注册表列表", httpMethod = "GET")
  public BaseResponse listAnnualRegistration(@RequestBody QAnnualRegistration search,
      @RequestParam(required = false, defaultValue = "1") long page,
      @RequestParam(required = false, defaultValue = "10") long pageSize) {
    search.setPage(page);
    search.setPageSize(pageSize);
    List<AnnualRegistration> list = annualRegistrationService.list(search);
    long totalCount = annualRegistrationService.count(search);
    PaginationResult paginationResult = new PaginationResult(list, page, pageSize, totalCount);
    return response(paginationResult);
  }

  @PutMapping("/club/annual/registration/{id}/status")
  @ApiOperation(value = "审核年度注册表", notes = "审核年度注册表", httpMethod = "PUT")
  public BaseResponse reviewAnnualRegistration(@PathVariable("id") Integer id,
      @RequestBody QAnnualRegistration item) {
    AnnualRegistration annualRegistration = annualRegistrationService.getById(id);
    if (annualRegistration != null) {
      if (annualRegistration.getAuditStatus() == AnnualRegStatus.UNDER_REVIEW.getCode()) {
        if (item.getStatus() == AnnualRegStatus.NOT_PASS.getCode()
            || item.getStatus() == AnnualRegStatus.PASS.getCode()) {
          annualRegistration.setAuditStatus(item.getStatus());
          int result = annualRegistrationService.update(annualRegistration);
          return response(result, null);
        }
      }
    }
    // illegal , failed
    return response(0, null);
  }
}
