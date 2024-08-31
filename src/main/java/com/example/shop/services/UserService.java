package com.example.shop.services;

import com.example.shop.controllers.requests.CreateUserRequest;
import com.example.shop.controllers.responses.user.UserResponse;
import com.example.shop.entities.UserEntity;
import com.example.shop.exceptions.user.UserNotFoundByIdException;
import com.example.shop.mappers.UserMapper;
import com.example.shop.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<UserResponse> create( CreateUserRequest user)
    {
        UserEntity newUser = UserEntity.builder()
                .name(user.name())
                .build();

        userRepository.save(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userMapper.toUserResponse(newUser));
    }

    public ResponseEntity<UserResponse> read(Long id)
    {
        UserEntity user = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundByIdException(id));

        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userMapper.toUserResponse(user));
    }

    public ResponseEntity<Optional<UserEntity>> findById(Long id)
    {
        return ResponseEntity.ok(
                this.userRepository.findById(id)
        );
    }

    public void delete(Long id)
    {
        this.userRepository.deleteById(id);
    }

    public UserEntity edit(Long id, UserEntity updatedUser)
    {
        Optional<UserEntity> user = this.userRepository.findById(id);

        user.ifPresent(
                userEntity -> userEntity.setName(updatedUser.getName())
        );

        return this.userRepository.save(user.get());


    }
}
