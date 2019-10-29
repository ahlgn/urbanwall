package cn.urbanwall.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtils {

    public static String uploadPicture(MultipartFile file,String uploadPath) throws IOException {
        //获取上传文件名称
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为"+fileName);
        //UUID随即名称
        String UUIDName= UUID.randomUUID().toString().replaceAll("-", "");
        //获取上传文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传文件的后缀名"+suffixName);
        //获得上传路径
        String filePath = uploadPath;
        System.out.println("上传路径为:"+filePath);
        //文件名: 随机新名称+后缀名
        fileName =UUIDName+suffixName;
        //新建文件
        File dest = new File(filePath + fileName);
        System.out.println("新建文件"+filePath+fileName);
        //如果没有就新建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
            System.out.println("没有就创建");
        }
        file.transferTo(dest);

//        return dest.getPath();
        return fileName;
    }

}
