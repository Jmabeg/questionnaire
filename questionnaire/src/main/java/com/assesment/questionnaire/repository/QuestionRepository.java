package com.assesment.questionnaire.repository;

import com.assesment.questionnaire.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
