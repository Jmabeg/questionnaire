package com.assesment.questionnaire.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    private Long id;

    private String answered;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    private Question question;

    public Answer() {
    }

    public Answer(Long id, String answered, Question question) {
        this.id = id;
        this.answered = answered;
        this.question = question;
    }
}
