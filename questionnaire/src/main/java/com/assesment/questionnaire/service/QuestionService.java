package com.assesment.questionnaire.service;

import com.assesment.questionnaire.model.Question;
import com.assesment.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll(){return this.questionRepository.findAll();}
    public Optional<Question> findById(Long id){return this.questionRepository.findById(id);}
    public Question save(Question question){return this.questionRepository.save(question);}
    public void delete(Long id){this.questionRepository.deleteById(id);}


}
