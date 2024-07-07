package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.request.PostAddRequest;
import com.Social_Media.backend.entity.Post;
import com.Social_Media.backend.repository.PostRepository;
import com.Social_Media.backend.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public int add(PostAddRequest postAddRequest) {
        Post post=modelMapper.map(postAddRequest,Post.class);
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public void delete(int postId) {
        try {
            if (postRepository.existsById(postId)) {
                postRepository.deleteById(postId);
            } else {
                System.out.println("No Post found");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
