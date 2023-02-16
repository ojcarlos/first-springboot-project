package com.ojcarlos.simplecrud.services;

import com.ojcarlos.simplecrud.entities.Question1;
import com.ojcarlos.simplecrud.entities.Question3;
import com.ojcarlos.simplecrud.repositories.Question1Repository;
import com.ojcarlos.simplecrud.repositories.Question3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Question3Services {
    @Autowired
    private Question3Repository repository;

    public List<Question3> findAll(){
        return repository.findAll();
    }

    public Question3 findById(Long id){
        Optional<Question3> obj = repository.findById(id);
        return obj.get();
    }

    public  void deleteById(long id){
        repository.deleteById(id);
    }
}
