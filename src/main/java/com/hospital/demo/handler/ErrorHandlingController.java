package com.hospital.demo.handler;

import com.hospital.demo.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ErrorHandlingController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity onException(Exception e) {
        log.error(e.getMessage());
        return  ResponseEntity.internalServerError().body(e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity onCustomException(CustomException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(e.getHttpcode()).body(e.getMessage());
    }

}
