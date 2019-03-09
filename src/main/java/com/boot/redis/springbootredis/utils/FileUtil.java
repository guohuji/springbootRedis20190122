package com.boot.redis.springbootredis.utils;

/*
    @authuor 郭胡记
    @date 2019/1/29 20:07
*/

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class FileUtil {
    public static String fileMd5(InputStream inputStream){
        try{
            return DigestUtils.md5DigestAsHex(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getPath(){
        return "/" + LocalDate.now().toString().replace("-","/") + "/";
    }

    public static String saveFile(MultipartFile file,String pathname){
        try{
            File targetFile = new File(pathname);
            if (targetFile.exists()){
                return pathname;
            }
            if (!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
            return pathname;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteFile(String fullPath) {
        File file = new File(fullPath);
        if(file.exists()){
            boolean flag = file.delete();
            if(flag){
                //返回一个抽象路径名数组，这些路径名表示此抽象路径名所表示目录中的文件。
                File[] files = file.getParentFile().listFiles();
//                for(File f : files){
//                    System.out.println(f+"==============");
//                }
                if(files == null || files.length == 0){
                    file.getParentFile().delete();
                }
            }
            return flag;
        }
        return false;
    }
}
