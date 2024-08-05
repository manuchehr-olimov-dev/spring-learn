package com.example.shop.controllers;

import com.example.shop.entities.UserEntity;
import com.example.shop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserEntity> create(@Valid @RequestBody UserEntity user)
    {
        return userService.create(user);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<UserEntity>> read(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(userService.findById(id).getBody());
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
