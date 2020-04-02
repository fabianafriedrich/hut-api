package com.cct.hut.api.model;

import com.cct.hut.api.enums.Status;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", user=" + user +
                ", answers=" + answers +
                ", postImages=" + postImages +
                ", postVotes=" + postVotes +
                ", postReports=" + postReports +
                '}';
    }
}
