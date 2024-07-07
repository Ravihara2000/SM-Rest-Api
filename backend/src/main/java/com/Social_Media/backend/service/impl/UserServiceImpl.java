package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.request.UserAddRequest;
import com.Social_Media.backend.dto.response.user.UserResponse;
import com.Social_Media.backend.entity.User;
import com.Social_Media.backend.repository.UserRepository;
import com.Social_Media.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<UserResponse> getAll() {
        List<User> users=userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(int id) {
        User user=userRepository.findById(id).orElse(null);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public User getById(int userId) {
        return userRepository.findById(userId).get();
    }
    



}
