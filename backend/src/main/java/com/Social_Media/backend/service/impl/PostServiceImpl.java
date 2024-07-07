package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.request.PostAddRequest;
import com.Social_Media.backend.dto.response.post.PostGetResponse;
import com.Social_Media.backend.dto.response.user.UserResponse;
import com.Social_Media.backend.entity.Post;
import com.Social_Media.backend.entity.PostImage;
import com.Social_Media.backend.repository.PostRepository;
import com.Social_Media.backend.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    @Override
    public String add(PostAddRequest postAddRequest) {
        Post post=modelMapper.map(postAddRequest,Post.class);
        postRepository.save(post);
        return "Post Added";
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

    @Override
    public List<PostGetResponse> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostGetResponse.class)).collect(Collectors.toList());
    }
}
