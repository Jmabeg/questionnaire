package com.assesment.questionnaire.controller;

import com.assesment.questionnaire.model.User;
import com.assesment.questionnaire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/users")
    public List<User> findAll(){return this.service.findAll();}

    @GetMapping("/users/{id}")
    public Optional<User> findById(@PathVariable("id") Long id){return this.service.findById(id);}

    @PostMapping("/users")
    public User save(User user){return this.service.save(user);}

    @PutMapping("/users/{id}")
    public User update(@PathVariable("id") Long id, User user){return this.service.save(user);}

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Long id){this.service.delete(id);}

}
