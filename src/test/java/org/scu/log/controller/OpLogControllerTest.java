package org.scu.log.controller;

import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseControllerTest;
import org.scu.utils.JsonUtil;
import org.scu.base.domain.BaseResponse;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * Created by Lamm on 2018/12/19.
 */
@EnableAutoConfiguration
public class OpLogControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void productBusinessList() throws Exception {
    ResponseEntity<BaseResponse> response =
      testRestTemplate.exchange("/user/log", HttpMethod.GET, requestEntity, BaseResponse.class);
    BaseResponse resp = response.getBody();
    System.out.println(JsonUtil.toJson(resp));
    Assert.assertEquals(StatusCode.SUCCESS, resp.getCode());
  }
}
