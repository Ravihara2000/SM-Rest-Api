package com.Social_Media.backend.service.impl;

import com.Social_Media.backend.dto.response.UserImage.UserImageResponse;
import com.Social_Media.backend.entity.UserImage;
import com.Social_Media.backend.repository.UserImageRepository;
import com.Social_Media.backend.service.UserImageService;
import com.Social_Media.backend.service.UserService;
import com.Social_Media.backend.utils.ImageUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserImageRepository userImageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserImage userImage;

    @Override
    public UserImageResponse upload(MultipartFile file, int userId) throws IOException {
        userImage.setData(ImageUtils.compressImage(file.getBytes()));
        userImage.setName(file.getOriginalFilename());
        userImage.setType(file.getContentType());
        userImage.setUser(userService.getById(userId));
        userImageRepository.save(userImage);
        return modelMapper.map(userImage,UserImageResponse.class);
    }

    @Override
    public byte[] download(int userId) {
        Optional<UserImage> userImage = userImageRepository.findByUser_Id(userId);
        return ImageUtils.decompressImage(userImage.get().getData());
    }
}
