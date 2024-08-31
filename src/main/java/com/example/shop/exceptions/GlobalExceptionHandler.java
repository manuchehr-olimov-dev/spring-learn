package com.example.shop.exceptions;

import com.example.shop.exceptions.user.UserNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException( ApplicationException exception)  {
        final ErrorResponse error = ErrorResponse.builder()
                                        .message(exception.getMessage())
                                        .details(List.of(exception.getMessage()))
                                        .build();

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(error);
    }

}
