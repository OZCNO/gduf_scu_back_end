package org.scu;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.scu.base.handler.AuthInterceptor;
import org.scu.base.handler.UrlInterceptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Lamm on 2018/12/19
 */
@Configuration
public class ScuWebMvcConfigurer extends WebMvcConfigurationSupport {

  @Autowired
  private UrlInterceptor urlInterceptor;

  @Autowired
  private AuthInterceptor authInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // add url interceptor
    registry.addInterceptor(urlInterceptor).addPathPatterns("/**");

    // add auth interceptor
    registry.addInterceptor(authInterceptor)
            .excludePathPatterns("/login",
                                 "/swagger-resources/**",
                                 "/webjars/**",
                                 "/v2/**",
                                 "/swagger-ui.html**")
            .addPathPatterns("/**");
  }

  /**
   * @param converters
   *   http message converters
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty,
                                         SerializerFeature.WriteMapNullValue,
                                         SerializerFeature.WriteDateUseDateFormat,
                                         SerializerFeature.WriteNullStringAsEmpty,
                                         SerializerFeature.WriteNullBooleanAsFalse);
    converter.setFastJsonConfig(fastJsonConfig);
    converters.add(converter);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // add swagger resources handlers
    registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}