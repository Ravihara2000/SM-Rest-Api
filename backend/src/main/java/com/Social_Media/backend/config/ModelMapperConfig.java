package com.Social_Media.backend.config;

import com.Social_Media.backend.dto.request.CommentAddRequest;
import com.Social_Media.backend.entity.Comment;
import com.Social_Media.backend.entity.Post;
import com.Social_Media.backend.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
