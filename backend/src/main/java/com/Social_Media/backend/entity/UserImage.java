package com.Social_Media.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_images")
public class UserImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "data",length = 1000)
    private byte[] data;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
