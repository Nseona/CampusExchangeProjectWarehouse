package com.example.campusexchange.utils;

/**
 * @author Lucky
 * @version 1.0.0
 *
 * 该接口定义了一系列状态码，供前端判断服务器业务处理状态
 * 200 - 请求成功。 服务器已成功处理了请求， 一般这表示服务器提供了请求的网页，主要是用于GET和POST请求。
 * 400 - 客户端的请求不合法
 * 401 - 请求未通过身份验证，或者访问被拒绝
 * 403 - 服务器理解请求，但拒绝执行
 * 503 - 服务器的未知错误
 * 204 - 服务器成功处理请求，但没有返回任何内容。
 * 500 - 服务器遇到内部错误，无法完成请求。
 * 404 - 服务器找不到客户端请求寻找的资源
 */
public interface StatusCode {
    int OK = 200;
    int UNAUTHORIZED = 401;
    int NON_STANDARD = 400;
    int UNKNOWN_SERVER_ERROR = 503;
    int REFUSE = 403;
    int NOT_CONTENT = 204;
    int INTERNAL_ERROR = 500;
    int NOT_FOUND = 404;
}
