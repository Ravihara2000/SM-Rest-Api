package com.Social_Media.backend.controller;

import com.Social_Media.backend.dto.request.CommentAddRequest;
import com.Social_Media.backend.entity.Comment;
import com.Social_Media.backend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<CommentAddRequest> addComment(@RequestBody CommentAddRequest commentAddRequest){
        Comment comment=commentService.addComment(commentAddRequest.getPostId(),commentAddRequest.getUserId(),commentAddRequest.getDescription());
        CommentAddRequest commentAddRequest1=modelMapper.map(comment,CommentAddRequest.class);
        return ResponseEntity.ok(commentAddRequest1);
    }
}
