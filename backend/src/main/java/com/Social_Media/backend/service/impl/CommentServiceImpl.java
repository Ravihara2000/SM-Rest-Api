package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.response.comment.CommentGetResponse;
import com.Social_Media.backend.entity.Comment;
import com.Social_Media.backend.entity.Post;
import com.Social_Media.backend.entity.User;
import com.Social_Media.backend.repository.CommentRepository;
import com.Social_Media.backend.repository.PostRepository;
import com.Social_Media.backend.repository.UserRepository;
import com.Social_Media.backend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Comment addComment(int postId, int userId, String description) {
        Post post=postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post not found"));
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Comment comment=new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setDescription(description);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentGetResponse> getAllComment() {
        List<Comment> comments=commentRepository.findAll();
        return comments.stream().map(comment -> modelMapper.map(comment,CommentGetResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<CommentGetResponse> getAllCommentByUser(int userId) {
        List<Comment> comments=commentRepository.findAllByUserId(userId);
        return comments.stream().map(comment -> modelMapper.map(comment,CommentGetResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<CommentGetResponse> getAllCommentByPost(int postId) {
        List<Comment> comments=commentRepository.findAllByPostId(postId);
        return comments.stream().map(comment -> modelMapper.map(comment,CommentGetResponse.class)).collect(Collectors.toList());
    }
}
