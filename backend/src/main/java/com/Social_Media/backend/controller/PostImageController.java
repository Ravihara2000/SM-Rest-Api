package com.Social_Media.backend.controller;

import com.Social_Media.backend.dto.response.UserImage.UserImageResponse;
import com.Social_Media.backend.dto.response.postImage.PostImageResponse;
import com.Social_Media.backend.service.PostImageService;
import com.Social_Media.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/vi/postimages")
public class PostImageController {
    @Autowired
    private PostImageService postImageService;

    @PostMapping("/upload")
    public ResponseEntity<PostImageResponse>upload(@RequestParam("image")MultipartFile file,@RequestParam int postId)throws IOException{
        PostImageResponse postImageResponse= postImageService.upload(file,postId);
        return new ResponseEntity<>(postImageResponse, HttpStatus.OK);
    }

    @GetMapping("/download/{postId}")
    public ResponseEntity<byte[]> download(@PathVariable int postId){
        byte[] image = postImageService.download(postId);
        if (image!=null){
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }



}
