package com.lazeapp.user.exceptions;

import com.lazeapp.user.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * @author : Obia Ugochukwu Vigo
 * email : ugochukwu.obia@teamapt.com
 * date : 21/10/2022
 **/

@RestControllerAdvice
public class AppExceptionHandler {



    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException (ResourceNotFoundException resourceNotFoundException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(resourceNotFoundException.getCode())
                .message(resourceNotFoundException.getMessage())
                .time(LocalDateTime.now()).build();
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {GenericException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException (GenericException genericException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(genericException.getCode())
                .message(genericException.getMessage())
                .time(LocalDateTime.now()).build();
        return  new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
