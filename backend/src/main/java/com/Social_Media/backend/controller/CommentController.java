package com.Social_Media.backend.controller;

import com.Social_Media.backend.dto.request.CommentAddRequest;
import com.Social_Media.backend.dto.response.comment.CommentGetResponse;
import com.Social_Media.backend.entity.Comment;
import com.Social_Media.backend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @DeleteMapping("/delete")
    private ResponseEntity<String> deleteComment(@RequestParam int id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CommentGetResponse>>getAllComment(){
        return new ResponseEntity<>(commentService.getAllComment(),HttpStatus.OK);
    }

    @GetMapping("/get-all-by-user/{userId}")
    public ResponseEntity<List<CommentGetResponse>>getAllCommentByUser(@PathVariable int userId){
        return new ResponseEntity<>(commentService.getAllCommentByUser(userId),HttpStatus.OK);
    }
    @GetMapping("/get-all-by-post/{postId}")
    public ResponseEntity<List<CommentGetResponse>>getAllCommentByPost(@PathVariable int postId){
        return new ResponseEntity<>(commentService.getAllCommentByPost(postId),HttpStatus.OK);
    }

}
