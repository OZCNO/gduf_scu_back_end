package org.scu.activity.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.scu.base.controller.BaseController;
import org.scu.base.domain.BaseResponse;
import org.scu.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lamm on 2019/4/7
 */
@RestController
public class UploadController extends BaseController {

  private static final String RESOURCE_API = "/api/file/";

  @Value("${file.uploadFolder}")
  private String uploadFolder;

  @PostMapping("/img")
  public BaseResponse upload(@RequestParam("file") MultipartFile file) {

    // 获取文件名
    String originFilename = file.getOriginalFilename();
    String suffix = originFilename.substring(originFilename.lastIndexOf(".") + 1);
    if (StringUtils.isEmpty(suffix)) {
      suffix = "";
    }
    String fileName = DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss") + "." + suffix;
    String finalPath = uploadFolder + fileName;
    try {
      file.transferTo(new File(finalPath));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return response(RESOURCE_API + fileName);
  }
}
