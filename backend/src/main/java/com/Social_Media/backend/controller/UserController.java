package com.Social_Media.backend.controller;

import com.Social_Media.backend.dto.request.UserAddRequest;
import com.Social_Media.backend.dto.response.user.UserResponse;
import com.Social_Media.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody UserAddRequest userAddRequest){
        userService.add(userAddRequest);
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserResponse>>getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponse>getById(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
}
