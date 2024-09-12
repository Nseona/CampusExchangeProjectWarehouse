package com.example.campusexchange.utils;

/**
 * @author Lucky
 * @version 1.0.0
 *
 * 该接口定义了一系列状态码，供前端判断服务器业务处理状态
 * 200 - 请求成功。 服务器已成功处理了请求， 一般这表示服务器提供了请求的网页，主要是用于GET和POST请求。
 * 400 - 客户端的请求不合法
 * 401 - 请求未通过身份验证，或者访问被拒绝
 * 503 - 服务器的未知错误
 */
public interface StatusCode {
    int OK = 200;
    int unauthorized = 401;
    int nonStandard = 400;
    int unknownServerError = 503;
}
