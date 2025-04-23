package com.ljw.syncpay.api.aop;

import com.ljw.syncpay.api.global.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleCustomException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Response.error(HttpStatus.NOT_FOUND.toString(), exception.getMessage()));
    }
}
