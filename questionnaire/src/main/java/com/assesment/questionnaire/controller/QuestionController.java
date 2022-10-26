package com.assesment.questionnaire.controller;

import com.assesment.questionnaire.model.Question;
import com.assesment.questionnaire.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }


    @GetMapping("/questions")
    public List<Question> findAll(){return this.service.findAll();}

    @GetMapping("/questions/{id}")
    public Optional<Question> findById(@PathVariable("id") Long id, @RequestBody Question question){return this.service.findById(id);}

    @PostMapping("/questions")
    public Question save(Question question){return this.service.save(question);}

    @PutMapping("/questions/{id}")
    public Question update(@PathVariable("id") Long id, Question question){return this.service.save(question);}

    @DeleteMapping("/questions/{id}")
    public void delete(@PathVariable("id") Long id){this.service.delete(id);}

}
