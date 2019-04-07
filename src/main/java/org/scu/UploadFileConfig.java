package org.scu;

import javax.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lamm on 2019/4/7
 */
@Configuration
public class UploadFileConfig {

  @Value("${file.uploadFolder}")
  private String uploadFolder;

  @Bean
  MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setLocation(uploadFolder);
    //文件最大
    factory.setMaxFileSize("5MB");
    // 设置总上传数据大小
    factory.setMaxRequestSize("10MB");
    return factory.createMultipartConfig();
  }
}
