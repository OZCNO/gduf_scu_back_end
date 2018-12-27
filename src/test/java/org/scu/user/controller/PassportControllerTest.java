package org.scu.user.controller;

import org.scu.ScuApplication;
import org.scu.base.conf.StatusCode;
import org.scu.base.domain.BaseResponse;
import org.scu.user.vo.QUser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lamm on 2018/12/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScuApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class PassportControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void login() throws Exception {
    QUser loginParams = new QUser();
    loginParams.setName("lamm");
    loginParams.setPassword("123456");
    BaseResponse result = testRestTemplate.postForObject("/login", loginParams, BaseResponse.class);
    Assert.assertEquals(StatusCode.SUCCESS, result.getCode());
  }
}
