package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.UserAddRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void add(UserAddRequest userAddRequest);
}
