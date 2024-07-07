package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.request.PostAddRequest;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    int add(PostAddRequest postAddRequest);

    void delete(int postId);
}
