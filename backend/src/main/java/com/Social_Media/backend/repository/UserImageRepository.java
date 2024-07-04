package com.Social_Media.backend.repository;

import com.Social_Media.backend.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage,Integer> {
    Optional<UserImage> findByUser_Id(int userId);
}
