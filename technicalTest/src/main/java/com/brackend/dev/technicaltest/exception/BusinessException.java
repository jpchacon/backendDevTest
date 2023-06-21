package com.brackend.dev.technicaltest.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException{


    private int status;

    public BusinessException(int status, String message){
        super(message);
        this.status = status;
    }
}
