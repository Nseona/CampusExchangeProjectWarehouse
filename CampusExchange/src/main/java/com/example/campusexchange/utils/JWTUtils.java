package com.example.campusexchange.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static String SIGNATURE = "token!@#$%^*#^$&SDYV3873huer2938";

    /**
     * 生成token
     * @param map //传入payload
     * @return 返回token
     *
     * JWT.create() 返回工厂类用于构建 token
     * builder.withClaim(k, v) 方法向 JWT 中添加负载
     * Calendar.getInstance() 获取当前时间实例
     * instance.add(偏移单位, 偏移量) 将时间实例按参数偏移
     * builder.withExpiresAt() 设定令牌过期时间
     * builder.sign(Algorithm.HMAC256(密钥)) 使用HMAC256算法和密钥SIGNATURE对JWT进行签名
     */
    public static String getToken(Map<String,String> map){
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.MINUTE,120);

        builder.withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(SIGNATURE)).toString();
    }

    /**
     * 验证token
     * @param token
     *
     * JWT.require(Algorithm实例).build() 构造了验证器
     */
    public static void verify(String token){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SIGNATURE)).build();
        DecodedJWT verify = build.verify(token);
    }

    /**
     *
     * @param token
     * @return
     *
     * 对 token 进行解码
     * DecodedJWT 对象中含有负载， 头部 等信息
     */
    public static DecodedJWT decryptToken(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
