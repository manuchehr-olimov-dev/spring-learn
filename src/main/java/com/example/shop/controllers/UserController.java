package com.example.shop.controllers;

import com.example.shop.controllers.requests.CreateUserRequest;
import com.example.shop.controllers.responses.user.UserResponse;
import com.example.shop.entities.UserEntity;
import com.example.shop.exceptions.user.UserNotFoundByIdException;
import com.example.shop.repositories.UserRepository;
import com.example.shop.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRep;

    @PostMapping("create")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest user)
    {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> read(@PathVariable("id") Long id)
    {
        return userService.read(id);
    }

    @GetMapping("ex")
    public String P(){

        UserEntity userEntity = userRep.findById(10L)
                .orElseThrow(
                () -> new UserNotFoundByIdException(10L)
        );

        return "123";
        //        return ResponseEntity.status(HttpStatus.OK).body("Nice");
    }


    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity edit(
            @PathVariable Long id,
            @RequestBody UserEntity updatedUser
    ){
        return userService.edit(id, updatedUser);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id)
    {
        userService.delete(id);
    }
}
