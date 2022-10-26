package com.assesment.questionnaire.controller;

import com.assesment.questionnaire.model.Answer;
import com.assesment.questionnaire.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class AnswerController {

    private final AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        this.service = service;
    }


    @GetMapping("/answers")
    public List<Answer> findAll(){return this.service.findAll();}

    @GetMapping("/answers/{id}")
    public Optional<Answer> findById(@PathVariable("id") Long id){return this.service.findById(id);}

    @PostMapping("/answers/{questionId}")
    public Answer save(@PathVariable("questionId") Long questionId, Answer answer){return this.service.save(questionId, answer);}

    @PutMapping("/answers/{id}")
    public Answer update(@PathVariable("id") Long id, Answer answer){return this.service.update(answer);}

    @DeleteMapping("/answers/{id}")
    public void delete(@PathVariable("id") Long id){this.service.delete(id);}

}