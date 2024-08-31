package com.example.shop.exceptions.user;

import com.example.shop.exceptions.ApplicationException;
import com.example.shop.exceptions.ErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public final class UserNotFoundByIdException extends ApplicationException {
    public static final String MESSAGE = "User with this ID not found. User ID is: ";

    public UserNotFoundByIdException(Long id) {
        super(MESSAGE + id, HttpStatus.NO_CONTENT);
    }
}
