package com.lomoy.javaandspring.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class StudentServiceException extends RuntimeException{

    public StudentServiceException(String foo_exception) {
    }
}
