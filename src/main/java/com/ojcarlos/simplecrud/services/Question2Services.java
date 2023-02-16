package com.ojcarlos.simplecrud.services;

import com.ojcarlos.simplecrud.entities.Question1;
import com.ojcarlos.simplecrud.entities.Question2;
import com.ojcarlos.simplecrud.repositories.Question1Repository;
import com.ojcarlos.simplecrud.repositories.Question2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Question2Services {

    @Autowired
    private Question2Repository repository;

    public List<Question2> findAll(){
        return repository.findAll();
    }

    public Question2 findById(Long id){
        Optional<Question2> obj = repository.findById(id);
        return obj.get();
    }

    public  void deleteById(long id){
        repository.deleteById(id);
    }
}
