package com.Social_Media.backend.dto.response.user;

import com.Social_Media.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    private int id;
    private String name;
    private String email;

/*    private List<UserFollowResponse> followers;
    private List<UserFollowingResponse> following;*/
}
