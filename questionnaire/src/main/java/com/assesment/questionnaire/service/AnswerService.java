package com.assesment.questionnaire.service;

import com.assesment.questionnaire.model.Answer;
import com.assesment.questionnaire.model.Question;
import com.assesment.questionnaire.repository.AnswerRepository;
import com.assesment.questionnaire.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public List<Answer> findAll(){return this.answerRepository.findAll();}
    public Optional<Answer> findById(Long id){return this.answerRepository.findById(id);}
    // public Answer save(Answer answer){return this.answerRepository.save(answer);}
    public void delete(Long id){this.answerRepository.deleteById(id);}


    public Answer save(Long questionId, Answer answer){
        if(answer == null)
            return null;

        Question question = questionRepository.findById(questionId).orElse(null);
        if(question == null)
            return null;

        answer.setQuestion(question);

        return answerRepository.save(answer);
    }

    public Answer update(Answer answer){return answerRepository.save(answer);}

}
