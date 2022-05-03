package com.example.wajavaw2.controller;

import com.example.wajavaw2.exception.StudentSaveFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {StudentSaveFailureException.class})
    protected ResponseEntity<Object> handleStudentControllerException(StudentSaveFailureException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ce n'est pas l'erreur que vous cherchez");
    }
}
