package org.scu.user.controller;

import org.scu.base.conf.StatusCode;
import org.scu.base.controller.BaseControllerTest;
import org.scu.user.vo.ModifyPasswordReq;
import org.scu.utils.JsonUtil;
import org.scu.base.domain.BaseResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * Created by Lamm on 2018/12/19.
 */
@EnableAutoConfiguration
public class UserControllerTest extends BaseControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void modifyPass() throws Exception {
    ModifyPasswordReq req = new ModifyPasswordReq();
    req.setNewPass("1234567");
    req.setOldPass("123456");
    requestHeaders.add("content-type","application/json");
    requestEntity = new HttpEntity<String>(JsonUtil.toJson(req),requestHeaders);
    ResponseEntity<BaseResponse> response = testRestTemplate.exchange("/user/password", HttpMethod.POST, requestEntity, BaseResponse.class);
    BaseResponse result = response.getBody();
    Assert.assertEquals(StatusCode.SUCCESS, result.getCode());

    req = new ModifyPasswordReq();
    req.setNewPass("123456");
    req.setOldPass("1234567");
    requestEntity = new HttpEntity<String>(JsonUtil.toJson(req),requestHeaders);
    response = testRestTemplate.exchange("/user/password", HttpMethod.POST, requestEntity, BaseResponse.class);
    result = response.getBody();
    Assert.assertEquals(StatusCode.SUCCESS, result.getCode());
  }
}
