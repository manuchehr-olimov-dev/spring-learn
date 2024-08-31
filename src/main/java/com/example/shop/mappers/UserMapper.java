package com.example.shop.mappers;

import com.example.shop.controllers.responses.user.UserResponse;
import com.example.shop.entities.UserEntity;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface UserMapper {
    UserResponse toUserResponse(UserEntity user);
}
