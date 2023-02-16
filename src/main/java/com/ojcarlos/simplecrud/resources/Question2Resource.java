package com.ojcarlos.simplecrud.resources;

import com.ojcarlos.simplecrud.entities.Question1;
import com.ojcarlos.simplecrud.entities.Question2;
import com.ojcarlos.simplecrud.services.Question1Services;
import com.ojcarlos.simplecrud.services.Question2Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/q2")
public class Question2Resource {

    @Autowired
    private Question2Services service;


    @GetMapping
    public ResponseEntity<Question2> findById(){
        List<Question2> questions = service.findAll();
        int size = questions.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt(size);
        Question2 question = questions.get(randomIndex);
        service.deleteById(question.getId());
        return  ResponseEntity.ok().body(question);
    }
}
