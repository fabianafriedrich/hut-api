package com.cct.hut.api.model;

import com.cct.hut.api.enums.Status;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Post implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationDate;

    private String title;

    private String description;

    private Status status;

    private Integer likes;

    private Integer dislikes;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Answer> answers;

    @OneToMany(mappedBy = "post")
    private Set<PostImage> postImages;

    @OneToMany(mappedBy = "post")
    private Set<PostVote> postVotes;

    @OneToMany(mappedBy = "post")
    private Set<PostReport> postReports;


    public Post(Long id, LocalDateTime creationDate, String title, String description, Status status, Integer likes, Integer dislikes) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
        this.status = status;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Post() {
    }
}
