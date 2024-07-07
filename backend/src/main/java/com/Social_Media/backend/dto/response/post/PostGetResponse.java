package com.Social_Media.backend.dto.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostGetResponse {
    private int id;
    private int userId;
    private String userName;
    private String Description;
}
