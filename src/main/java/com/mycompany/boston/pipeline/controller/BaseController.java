package com.mycompany.boston.pipeline.controller;

import com.mycompany.boston.pipeline.exception.BadRequestException;
import com.mycompany.boston.pipeline.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Api
public abstract class BaseController {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    HashMap<String, String> handleException(ResourceNotFoundException e) {
        return new HashMap<String, String>() {
            {
                put("message", e.getMessage());
            }
        };
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    HashMap<String, String> handleException(BadRequestException e) {
        return new HashMap<String, String>() {
            {
                put("message", e.getMessage());
            }
        };
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    HashMap<String, String> handleException(Throwable e) {
        return new HashMap<String, String>() {
            {
                put("message", e.toString());
            }
        };
    }
}
