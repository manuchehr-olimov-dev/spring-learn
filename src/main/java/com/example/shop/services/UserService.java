package com.example.shop.services;

import com.example.shop.entities.UserEntity;
import com.example.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserEntity> create(UserEntity user)
    {
        UserEntity newUser = new UserEntity();
        newUser.setName(user.getName());
        return ResponseEntity.ok(this.userRepository.save(newUser));
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
