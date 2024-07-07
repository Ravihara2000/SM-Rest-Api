package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.PostAddRequest;
import com.Social_Media.backend.dto.response.post.PostGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    String add(PostAddRequest postAddRequest);

    void delete(int postId);


    List<PostGetResponse> getAll();
}
