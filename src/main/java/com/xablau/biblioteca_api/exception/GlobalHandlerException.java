package com.xablau.biblioteca_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(AbstractExceptionHandler.class)
    public ResponseEntity<Map<String, Object>> exceptionHandler(AbstractExceptionHandler ex){
        Map<String, Object> exception = new HashMap<>();
        exception.put("status: ", ex.getHttpStatus().value());
        exception.put("error: ", ex.getHttpStatus());
        exception.put("message: ", ex.getMessage());
        exception.put("timestamp: ", LocalDateTime.now());

        return ResponseEntity.status(ex.getHttpStatus()).body(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro404(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.stream().map(DadosErroValidacao::new).toList());
    }


    public record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
