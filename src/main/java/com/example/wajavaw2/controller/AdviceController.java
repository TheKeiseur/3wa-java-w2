package com.example.wajavaw2.controller;

import com.example.wajavaw2.exception.StudentSaveFailureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class AdviceController extends ResponseEntityExceptionHandler {

    // Response status = status to return, not status to catch
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {StudentSaveFailureException.class})
    public ResponseEntity<Object> handleStudentControllerException(StudentSaveFailureException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ce n'est pas l'erreur que vous cherchez");
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    public Map<String, String> handleStudentValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
