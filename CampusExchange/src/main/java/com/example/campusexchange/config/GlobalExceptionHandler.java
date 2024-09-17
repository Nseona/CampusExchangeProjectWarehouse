package com.example.campusexchange.config;

import com.example.campusexchange.controller.PostController;
import com.example.campusexchange.exception.MapperException;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handleServiceException(ServiceException e){
        logger.warn(e.getMessage());
        return new Result(e.getStatusCode(), "服务器繁忙， 请稍后再试。");
    }

    @ExceptionHandler(MapperException.class)
    @ResponseBody
    public Result handleMapperException(MapperException e){
        logger.warn(e.getMessage());
        return new Result(e.getStatusCode(), "服务器繁忙， 请稍后再试。");
    }

}
