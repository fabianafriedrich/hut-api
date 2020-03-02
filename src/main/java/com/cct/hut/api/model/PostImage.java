package com.cct.hut.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PostImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post post;

    public PostImage(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public PostImage() {
    }
}
