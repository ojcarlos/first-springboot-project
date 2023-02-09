package com.ojcarlos.simplecrud.services;

import com.ojcarlos.simplecrud.entities.Question1;
import com.ojcarlos.simplecrud.entities.User;
import com.ojcarlos.simplecrud.repositories.Question1Repository;
import com.ojcarlos.simplecrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Question1Services {

    @Autowired
    private Question1Repository repository;

    public List<Question1> findAll(){
        return repository.findAll();
    }

    public Question1 findById(Long id){
        Optional<Question1> obj = repository.findById(id);
        return obj.get();
    }
}
