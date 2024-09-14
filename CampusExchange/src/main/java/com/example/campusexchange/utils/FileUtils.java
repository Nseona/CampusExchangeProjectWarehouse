package com.example.campusexchange.utils;

import com.example.campusexchange.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class FileUtils {
    @Value("fileRootPath")
    private String fileRootPath;

    /**
     *
     * @param filePath 文件绝对路径
     * @return base64 字符串
     *
     * 将指定路径文件 转为 base64 字符串
     */
    public static String toBase64(String filePath) {
        FileInputStream inputStream = null;
        String base64Str = "";
        try {
            // 获取 base64 编码器
            Base64.Encoder encoder = Base64.getEncoder();
            inputStream = new FileInputStream(filePath);
            int available = inputStream.available();
            byte[] bytes = new byte[available];
            inputStream.read(bytes);
            base64Str = encoder.encodeToString(bytes);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.unknownServerError, "服务器繁忙, 请稍后再试");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                throw new ServiceException(StatusCode.unknownServerError, "服务器繁忙，请稍后再试");
            }
        }

        return base64Str;
    }

    /**
     * 将 MultipartFile 类型文件 存储到本地
     */
    public static void fastenMultipart(MultipartFile multipartFile, String fileName){
        File dest = new File("C:/Users/Lucky/Desktop/campus-exchange-project-warehouse/CampusExchange/src/main/resources/static/" + fileName);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFileSuffix(MultipartFile multipartFile){
        String oFilename = multipartFile.getOriginalFilename();
        String suffix = oFilename.substring(oFilename.lastIndexOf(".") + 1);

        return suffix;
    }
}
