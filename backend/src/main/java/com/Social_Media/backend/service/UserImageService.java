package com.Social_Media.backend.service;

import com.Social_Media.backend.dto.response.UserImage.UserImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserImageService {
    UserImageResponse upload(MultipartFile file, int userId) throws IOException;

    byte[] download(int userId);
}
