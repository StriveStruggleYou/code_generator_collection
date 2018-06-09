package org.ssy;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

  private static final String TEMPLATE_PATH = "curl_code/src/main/java/templates";

  private static final String CLASS_PATH = "curl_code/src/main/java/org/ssy/";

  public static void main(String[] args) {

    createTemple();

//    String requestMethod = "GET";
//
//    String requestUrl = "/projects/:id/repository/branches/:branch";
//
//    String result[] = requestUrl.split("/");
//    List<String> paramList = new ArrayList<>();
//    Map<String, Integer> paramMap = new HashMap<>();
//    for (int i = 0; i < result.length; i++) {
//      if (result[i].startsWith(":")) {
//        paramMap.put(result[i].substring(1, result[i].length()), i);
//      } else {
//        if (!result[i].equals("")) {
//          paramList.add(result[i]);
//        }
//      }
//    }

  }


  public static void createTemple() {
    Configuration configuration = new Configuration();
    Writer out = null;
    try {
      // step2 获取模版路径
      configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
      // step3 创建数据模型
      Map<String, Object> dataMap = new HashMap<String, Object>();
      dataMap.put("methodName", "listBranchess");
      dataMap.put("methodParam", "projectId");
      dataMap.put("requestMethod", "Get");
      // step4 加载模版文件
      Template template = configuration.getTemplate("ok3.ftl");
      // step5 生成数据
      File docFile = new File(CLASS_PATH + "AutoCodeDemo1.javas");
      out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
      // step6 输出文件
      template.process(dataMap, out);
      System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^AutoCodeDemo.java 文件创建成功 !");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (null != out) {
          out.flush();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }

  }


  public static void createAll() {

    String requestUrl = "https://my.oschina.net/QAAQ/radar/searchUserRadarMap";
    String requestMethod = "POST";
    String requestContentType = "application/x-www-form-urlencoded; charset=UTF-8";
    String formData = "userId=2285811&skillsNum=5";



  }


}
