package com.Social_Media.backend.mappers;

import com.Social_Media.backend.dto.response.user.UserResponse;
import com.Social_Media.backend.entity.User;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    //List<UserResponse> usersToResponse(List<User> users);
}
