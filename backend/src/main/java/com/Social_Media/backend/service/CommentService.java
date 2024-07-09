package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.CommentAddRequest;
import com.Social_Media.backend.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Comment addComment(int postId, int userId, String description);

    void deleteComment(int id);
}
