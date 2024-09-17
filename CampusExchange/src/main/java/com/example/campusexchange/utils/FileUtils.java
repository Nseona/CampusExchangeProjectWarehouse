package com.example.campusexchange.utils;

import com.example.campusexchange.controller.PostPicController;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.PostPic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(PostPicController.class);

    @Value("${fileRootPath}")
    private String fileRootPath;

    public List<String> toBase64(List<PostPic> PostPicList){

        List<String> base64List = new ArrayList<>();

        for (PostPic postPic : PostPicList) {
            String base64 = this.toBase64(postPic.getPath());
            base64List.add(base64);
        }

        return base64List;

    }


    public String getFileSuffix(MultipartFile multipartFile){
        String oFilename = multipartFile.getOriginalFilename();
        String suffix = oFilename.substring(oFilename.lastIndexOf(".") + 1);

        return suffix;
    }

    /**
     * 将 MultipartFile 类型文件 存储到本地
     */
    public void fastenMultipart(MultipartFile multipartFile, String fileName){
        File dest = new File("C:/Users/Lucky/Desktop/campus-exchange-project-warehouse/CampusExchange/src/main/resources/static/" + fileName);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param filePath 文件绝对路径
     * @return base64 字符串
     *
     * 将指定路径文件 转为 base64 字符串
     */
    public String toBase64(String filePath) {

        FileInputStream inputStream = null;
        String base64Str = "";
        try {
            // 获取 base64 编码器
            Base64.Encoder encoder = Base64.getEncoder();
            inputStream = new FileInputStream(fileRootPath +  filePath);
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            base64Str = encoder.encodeToString(bytes);
        } catch (FileNotFoundException e) {
            logger.info("读入文件" + filePath + "时，发生错误" + e);
            throw new ServiceException(StatusCode.UNKNOWN_SERVER_ERROR, "服务器繁忙, 请稍后再试");
        } catch (Exception e){
            throw new ServiceException(StatusCode.UNKNOWN_SERVER_ERROR, "服务器繁忙, 请稍后再试");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                throw new ServiceException(StatusCode.UNKNOWN_SERVER_ERROR, "服务器繁忙，请稍后再试");
            }
        }

        return base64Str;
    }

    public String getFileRootPath() {
        return fileRootPath;
    }
}
