package com.cct.hut.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PostVote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer likes;

    private Integer dislikes;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    public PostVote(Long id, Integer likes, Integer dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public PostVote() {
    }

}
