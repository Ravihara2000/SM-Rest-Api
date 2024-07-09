package com.Social_Media.backend.dto.response.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetResponse {
    private int id;
    private int postId;
    private int userId;
    private String userName;
    private String description;
}
