package org.scu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by Lamm on 2018/12/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

  public static final String SWAGGER_SCAN_PACKAGE_USER = "org.scu.user";

//  @Bean
//  public Docket createUserRestApi() {
//    return createRestApi("user", SWAGGER_SCAN_PACKAGE_USER);
//  }
//
//  public Docket createRestApi(String groupName, String basePackage) {
//    return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(setHeaderToken())
//                                                  .apiInfo(apiInfo())
//                                                  .groupName(groupName)
//                                                  .select()
//                                                  .apis(RequestHandlerSelectors.basePackage(
//                                                    basePackage))
//                                                  .paths(PathSelectors.any())
//                                                  .build();
//  }

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .globalOperationParameters(setHeaderToken())
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("org.scu"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("MM-AD-PLATFORM Restful API DOCUMENTS")
                               .description("Project For BOC Team")
                               .termsOfServiceUrl("https://www.baidu.com/")
                               .contact(new Contact("lamm",
                                                    "https://demo.com",
                                                    "aaa@aaa.com"))
                               .version("0.0.1")
                               .build();
  }

  /**
   * add token for testing APIs
   *
   * @return
   */
  private List<Parameter> setHeaderToken() {
    ParameterBuilder tokenPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<>();
    tokenPar.name("Authorization")
            .description("Token")
            .defaultValue("Bearer 1 f8tefYzu32aN5n4YfnXxpqaR1s3EaUCv5VaCXwI6")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();
    pars.add(tokenPar.build());
    return pars;
  }
}
