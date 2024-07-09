package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.CommentAddRequest;
import com.Social_Media.backend.dto.response.comment.CommentGetResponse;
import com.Social_Media.backend.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment addComment(int postId, int userId, String description);

    void deleteComment(int id);


    List<CommentGetResponse> getAllComment();


    List<CommentGetResponse> getAllCommentByUser(int userId);


    List<CommentGetResponse> getAllCommentByPost(int postId);
}
