package com.example.campusexchange.aop;

import com.example.campusexchange.exception.MapperException;
import com.example.campusexchange.utils.StatusCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class PostDaoAspect {
    @Pointcut("execution(* com.example.campusexchange.dao.PostDao.selectPostAllByField(..))")
    public void selectPostAllByFieldLittle() {}

    @Around("selectPostAllByFieldLittle()")
    public Object aroundSelectPostAllByField(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String mode = (String) (args[0]);
        List<String> options = Arrays.asList("DESC", "ASC");

        if (!options.contains(mode)){
            throw new MapperException(StatusCode.internalError, "PostDao.selectPostAllByField 方法的参数 " + mode + " 不正确");
        }

        return joinPoint.proceed();
    }
}