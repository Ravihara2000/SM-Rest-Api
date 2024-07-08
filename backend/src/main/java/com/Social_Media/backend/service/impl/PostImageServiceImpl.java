package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.response.UserImage.UserImageResponse;
import com.Social_Media.backend.dto.response.postImage.PostImageResponse;
import com.Social_Media.backend.entity.PostImage;
import com.Social_Media.backend.entity.UserImage;
import com.Social_Media.backend.repository.PostImageRepository;
import com.Social_Media.backend.service.PostImageService;
import com.Social_Media.backend.service.PostService;
import com.Social_Media.backend.utils.ImageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PostImageServiceImpl implements PostImageService {
    @Autowired
    private PostImageRepository postImageRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostImage postImage;

    @Override
    public PostImageResponse upload(MultipartFile file, int postId) throws IOException {
        postImage.setData(ImageUtils.compressImage(file.getBytes()));
        postImage.setName(file.getOriginalFilename());
        postImage.setType(file.getContentType());
        postImage.setPost(postService.getById(postId));
        postImageRepository.save(postImage);
        return modelMapper.map(postImage,PostImageResponse.class);
    }

    @Override
    public byte[] download(int postId) {
        Optional<PostImage> postImage = postImageRepository.findPostImagesByPostId(postId);
        if (postImage.isPresent()){
            return ImageUtils.decompressImage(postImage.get().getData());
        }
        return null;

    }

}
