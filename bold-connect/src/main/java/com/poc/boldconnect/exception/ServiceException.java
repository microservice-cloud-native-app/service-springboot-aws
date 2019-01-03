package com.poc.boldconnect.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    String message;

    public ServiceException(String message) {
        this.message = message;
    }
}
