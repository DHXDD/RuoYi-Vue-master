package com.ruoyi.common.utils.poi;

import com.deepoove.poi.XWPFTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

/**
 * Word模板工具
 * Poi-tl模板引擎官方文档：http://deepoove.com/poi-tl/
 */
@Component
public class WordUtil {

    /**
     * 根据模板填充内容生成word，并下载
     * @param templatePath word模板文件路径
     * @param paramMap     替换的参数集合
     */
    public static void downloadWord(String filePath, String templatePath, Map<String, Object> paramMap) throws IOException {

        Long time = new Date().getTime();
        // 生成的word格式
        String formatSuffix = ".docx";
        // 拼接后的文件名
        String fileName = time + formatSuffix;

        String path = new ClassPathResource(filePath).getFile().getPath();

        filePath = path+"\\"+fileName;

        File newFile = new File(filePath);

        //设置生成的文件存放路径，可以存放在你想要指定的路径里面
//        String rootPath="D:/word/"+ File.separator+"file/word/";

        //判断目标文件所在目录是否存在
        if(!newFile.getParentFile().exists()){

            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();

        }

        templatePath = new ClassPathResource(templatePath).getFile().getPath();

        // 读取模板templatePath并将paramMap的内容填充进模板，即编辑模板(compile)+渲染数据(render)
        XWPFTemplate template = XWPFTemplate.compile(templatePath).render(paramMap);
        try {
            OutputStream out = Files.newOutputStream(Paths.get(filePath));//输出路径(下载到指定路径)
            // 将填充之后的模板写入filePath
            template.write(out);//将template写到OutputStream中
            out.flush();
            out.close();
            template.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadWord(OutputStream out,String templatePath, Map<String, Object> paramMap) {

        Long time = new Date().getTime();
        // 生成的word格式
        String formatSuffix = ".docx";
        // 拼接后的文件名
        String fileName = time + formatSuffix;

        //设置生成的文件存放路径，可以存放在你想要指定的路径里面
        String rootPath="D:/mimi/"+File.separator+"file/word/";

        String filePath = rootPath+fileName;

        File newFile = new File(filePath);
        //判断目标文件所在目录是否存在
        if(!newFile.getParentFile().exists()){
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }

        // 读取模板templatePath并将paramMap的内容填充进模板，即编辑模板(compile)+渲染数据(render)
        XWPFTemplate template = XWPFTemplate.compile(templatePath).render(paramMap);
        try {
            //out = new FileOutputStream(filePath);//输出路径(下载到指定路径)
            // 将填充之后的模板写入filePath
            template.write(out);//将template写到OutputStream中
            out.flush();
            out.close();
            template.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
