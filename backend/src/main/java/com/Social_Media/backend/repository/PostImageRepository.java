package com.Social_Media.backend.repository;

import com.Social_Media.backend.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage,Integer> {

    Optional<PostImage> findPostImagesByPostId(int postId);
}
