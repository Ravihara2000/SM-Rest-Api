package com.Social_Media.backend.controller;

import com.Social_Media.backend.dto.request.PostAddRequest;
import com.Social_Media.backend.dto.response.post.PostGetResponse;
import com.Social_Media.backend.service.PostService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<String> addPost(@RequestBody PostAddRequest postAddRequest){
        String postId = postService.add(postAddRequest);
        return new ResponseEntity<>(postId, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePost(@RequestParam int postId){
        postService.delete(postId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PostGetResponse>>getAll(){
        return new ResponseEntity<>(postService.getAll(),HttpStatus.OK);
    }

}
