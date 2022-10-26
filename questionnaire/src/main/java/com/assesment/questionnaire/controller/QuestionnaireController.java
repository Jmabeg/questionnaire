package com.assesment.questionnaire.controller;

import com.assesment.questionnaire.model.Question;
import com.assesment.questionnaire.model.Questionnaire;
import com.assesment.questionnaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class QuestionnaireController {

    private final QuestionnaireService service;

    @Autowired
    public QuestionnaireController(QuestionnaireService service) {
        this.service = service;
    }


    @GetMapping("/questionnairies")
    public List<Questionnaire> findAll(){return this.service.findAll();}

    @GetMapping("/questionnairies/{id}")
    public Optional<Questionnaire> findById(@PathVariable("id") Long id){return this.service.findById(id);}

    @PostMapping("/questionnairies")
    public Questionnaire save(Questionnaire questionnaire){return this.service.save(questionnaire);}

    @PutMapping("/questionnairies/{id}")
    public Questionnaire update(@PathVariable("id") Long id, Questionnaire questionnaire){return this.service.save(questionnaire);}

    @DeleteMapping("/questionnairies/{id}")
    public void delete(@PathVariable("id") Long id){this.service.delete(id);}

}
