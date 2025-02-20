package com.xablau.biblioteca_api.exception.authorExceptions;

import com.xablau.biblioteca_api.exception.AbstractExceptionHandler;
import org.springframework.http.HttpStatus;

public class AuthorEmailAreadyExist extends AbstractExceptionHandler {

    public AuthorEmailAreadyExist(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
