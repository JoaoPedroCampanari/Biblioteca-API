package com.xablau.biblioteca_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AbstractExceptionHandler extends RuntimeException{

    private HttpStatus httpStatus;

    public AbstractExceptionHandler(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
