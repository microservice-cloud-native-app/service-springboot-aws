package com.poc.boldconnect.exception;

import lombok.Data;
/**
 * Created by GK82893 on 3/8/2017.
 */
@Data
public class ClientSideException extends RuntimeException {

    String message;

    public ClientSideException(String message) {
        this.message = message;
    }
}

