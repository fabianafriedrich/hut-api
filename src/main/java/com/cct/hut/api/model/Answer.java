package com.cct.hut.api.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime creationDate;

    private String text;

    private Boolean correctAnswer;

    private Integer likes;

    private Integer dislikes;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    private Post post;

    @OneToMany(mappedBy = "answer")
    private List<AnswerImage> answerImages;

    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> answerVotes;

    @OneToMany(mappedBy = "answer")
    private List<AnswerReport> answerReports;


    public Answer(Long id, LocalDateTime creationDate, String text, Boolean correctAnswer, Integer likes, Integer dislikes) {
        this.id = id;
        this.creationDate = creationDate;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.likes = likes;
        this.dislikes = dislikes;


    }

    public Answer() {
    }
}
