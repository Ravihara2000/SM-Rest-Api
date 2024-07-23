package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.response.postImage.PostImageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PostImageService {

    PostImageResponse upload(MultipartFile file, int postId) throws IOException;

    byte[] download(int postId);

    List<byte[]> getAllImages();
}
