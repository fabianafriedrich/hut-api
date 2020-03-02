package com.cct.hut.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AnswerImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "fk_answer")
    private Answer answer;

    public AnswerImage(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public AnswerImage() {
    }
}
