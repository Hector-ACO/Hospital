package com.hospital.demo.exception;

import lombok.Getter;

public class CustomException extends Exception{

    public CustomException(int httpcode, String message) {
        this.message = message;
        this.httpcode = httpcode;
    }

    @Getter
    private Integer httpcode = 500;

    @Getter
    private String message = "";

}
