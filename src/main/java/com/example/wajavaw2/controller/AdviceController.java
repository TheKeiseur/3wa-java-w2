package com.example.wajavaw2.controller;

import com.example.wajavaw2.exception.StudentRegistrationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class AdviceController {

    // Response status = status to return, not status to catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentRegistrationFailedException.class)
    public ResponseEntity<ErrorDTO> generateNotFoundException(StudentRegistrationFailedException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.name());
        errorDTO.setTime(new Date().toString());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
