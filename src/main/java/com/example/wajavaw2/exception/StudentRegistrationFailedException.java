package com.example.wajavaw2.exception;

import org.springframework.http.HttpStatus;

public class StudentRegistrationFailedException extends RuntimeException {

    public StudentRegistrationFailedException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
