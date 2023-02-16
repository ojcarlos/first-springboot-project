package com.ojcarlos.simplecrud.resources;

import com.ojcarlos.simplecrud.entities.Question1;
import com.ojcarlos.simplecrud.services.Question1Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import java.util.List;

@RestController
@RequestMapping(value = "/q1")
public class Question1Resource {
    @Autowired
    private Question1Services service;


    @GetMapping
    public ResponseEntity<Question1> findById(){
        List<Question1> questions = service.findAll();
        int size = questions.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(size);
        Question1 question = questions.get(randomIndex);
        service.deleteById(question.getId());
        return  ResponseEntity.ok().body(question);
    }

}
