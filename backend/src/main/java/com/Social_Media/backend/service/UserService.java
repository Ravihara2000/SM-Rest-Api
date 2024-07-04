package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.UserAddRequest;
import com.Social_Media.backend.dto.response.user.UserResponse;
import com.Social_Media.backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(UserAddRequest userAddRequest);

    List<UserResponse> getAll();


    UserResponse getUserById(int id);

    User getById(int userId);
}
