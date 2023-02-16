package com.ojcarlos.simplecrud.resources;

import com.ojcarlos.simplecrud.entities.Question2;
import com.ojcarlos.simplecrud.entities.Question3;
import com.ojcarlos.simplecrud.services.Question2Services;
import com.ojcarlos.simplecrud.services.Question3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/q3")
public class Question3Resource {
    @Autowired
    private Question3Services service;


    @GetMapping
    public ResponseEntity<Question3> findById(){
        List<Question3> questions = service.findAll();
        int size = questions.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(size);
        Question3 question = questions.get(randomIndex);
        service.deleteById(question.getId());
        return  ResponseEntity.ok().body(question);
    }
}
