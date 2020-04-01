package com.cct.hut.api.model;

import com.cct.hut.api.enums.Roles;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private int points;

    @Enumerated
    private Roles role;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @OneToMany(mappedBy = "user")
    private Set<Answer> answers;

    @OneToMany(mappedBy = "user")
    private Set<PostVote> postVotes;

    @OneToMany(mappedBy = "user")
    private Set<AnswerVote> answerVotes;

    @OneToMany(mappedBy = "user")
    private Set<PostReport> postReports;

    @OneToMany(mappedBy = "user")
    private Set<AnswerReport> answerReports;

    public User(Long id, String email,String password, String name, int points, Roles role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.points = points;
        this.role = role;
    }

    public User() {
    }
}
