package com.urlshortener.redirectshorturl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static String messageFormat = "Resource %s not found";

    public ResourceNotFoundException(String id) {
        super(String.format(messageFormat, id));
    }
}
