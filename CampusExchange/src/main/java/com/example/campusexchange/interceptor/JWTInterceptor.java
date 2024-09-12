package com.example.campusexchange.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.campusexchange.utils.JWTUtils;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.utils.StatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT验证拦截器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Result result = new Result();

        try{
            JWTUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            result.setMessage("无效签名");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            result.setMessage("token过期");

        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            result.setMessage("token算法不一致");

        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("token失效");
        }
        result.setStatusCode(StatusCode.nonStandard);

        String json = new ObjectMapper().writeValueAsString(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);

        return false;
    }
}
