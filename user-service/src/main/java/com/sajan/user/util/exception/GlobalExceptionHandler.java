package com.sajan.user.util.exception;

import com.sajan.user.util.HeaderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException exception){
        return ResponseEntity.notFound().headers(HeaderUtil.exceptionAlert(exception.getMessage())).build();
    }
}
