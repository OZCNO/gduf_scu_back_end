package org.scu.base.controller;

import org.scu.ScuApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lamm on 2018/12/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScuApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class BaseControllerTest {

  @Autowired
  protected TestRestTemplate testRestTemplate;

  protected HttpEntity<String> requestEntity;

  protected HttpHeaders requestHeaders;

  @Before
  public void initLoginToken() {
    requestHeaders = new HttpHeaders();
    requestHeaders.add("Authorization", "Bearer 1 JRpa6ZMERJrTeK1pU5vnWBa6A52EXRRm1QBj6mgf");
    requestEntity = new HttpEntity<String>("", requestHeaders);
  }
}
