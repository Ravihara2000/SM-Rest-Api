package com.Social_Media.backend.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_following_id")
    User following;
}
