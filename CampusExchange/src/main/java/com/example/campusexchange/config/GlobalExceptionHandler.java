package com.example.campusexchange.config;

import com.example.campusexchange.dto.Dto;
import com.example.campusexchange.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Dto handleServiceException(ServiceException e){
        return new Dto(e.getStatusCode(), e.getMessage());
    }
}
