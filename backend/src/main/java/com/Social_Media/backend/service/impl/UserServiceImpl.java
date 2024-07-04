package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.request.UserAddRequest;
import com.Social_Media.backend.entity.User;
import com.Social_Media.backend.repository.UserRepository;
import com.Social_Media.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(UserAddRequest userAddRequest) {
        User user = modelMapper.map(userAddRequest,User.class);
        userRepository.save(user);
    }
}
