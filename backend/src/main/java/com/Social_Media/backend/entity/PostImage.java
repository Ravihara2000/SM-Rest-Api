package com.Social_Media.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "data",length = 65555)
    private byte[] data;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}
