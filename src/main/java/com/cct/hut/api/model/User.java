package com.cct.hut.api.model;

import com.cct.hut.api.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Answer> answers;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<PostVote> postVotes;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<AnswerVote> answerVotes;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<PostReport> postReports;

    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", points=" + points +
                ", role=" + role +
                ", posts=" + posts +
                ", answers=" + answers +
                ", postVotes=" + postVotes +
                ", answerVotes=" + answerVotes +
                ", postReports=" + postReports +
                ", answerReports=" + answerReports +
                '}';
    }
}
