package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.PostAddRequest;
import com.Social_Media.backend.dto.response.post.PostGetResponse;
import com.Social_Media.backend.dto.response.postImage.PostImageResponse;
import com.Social_Media.backend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    String add(PostAddRequest postAddRequest);

    void delete(int postId);


    List<PostGetResponse> getAll();


    PostGetResponse getPostById(int postId);


    List<PostGetResponse> getAllPostByUser(int userId);

    Post getById(int postId);
}
