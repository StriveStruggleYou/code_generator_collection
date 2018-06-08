package org.ssy;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

  private static final String TEMPLATE_PATH = "freemarker_base/src/main/java/templates";

  private static final String CLASS_PATH = "freemarker_base/src/main/java/org/ssy/";


  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    Writer out = null;
    try {
      // step2 获取模版路径
      configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
      // step3 创建数据模型
      Map<String, Object> dataMap = new HashMap<String, Object>();
      dataMap.put("classPath", "com.freemark.hello");
      dataMap.put("className", "AutoCodeDemo");
      dataMap.put("helloWorld", "通过简单的 <代码自动生产程序> 演示 FreeMarker的HelloWorld！");
      // step4 加载模版文件
      Template template = configuration.getTemplate("hello.ftl");
      // step5 生成数据
      File docFile = new File(CLASS_PATH + "AutoCodeDemo1.java");
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

}


