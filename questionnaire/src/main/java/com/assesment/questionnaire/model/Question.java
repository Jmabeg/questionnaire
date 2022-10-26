package com.assesment.questionnaire.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer category;

    private String options;

    @ManyToOne()
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;

    public Question() {
    }

    public Question(String title, Integer category, String options) {
        this.title = title;
        this.category = category;
        this.options = options;
    }

    public Question(String title, Integer category, String options, Questionnaire questionnaire) {
        this.title = title;
        this.category = category;
        this.options = options;
        this.questionnaire = questionnaire;
    }
}
