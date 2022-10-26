package com.assesment.questionnaire.service;

import com.assesment.questionnaire.model.Questionnaire;
import com.assesment.questionnaire.model.User;
import com.assesment.questionnaire.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> findAll(){return this.questionnaireRepository.findAll();}
    public Optional<Questionnaire> findById(Long id){return this.questionnaireRepository.findById(id);}
    public Questionnaire save(Questionnaire questionnaire){return this.questionnaireRepository.save(questionnaire);}
    public void delete(Long id){this.questionnaireRepository.deleteById(id);}
}
