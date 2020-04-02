package com.cct.hut.api.service;

import com.cct.hut.api.model.Answer;
import com.cct.hut.api.repository.AnswearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AnswerService {

    /*Spring Dependence Injection */
    @Autowired
    private AnswearRepository answearRepository;

    /*Method to save answer on database*/
    public Answer save(Answer answer){
        return answearRepository.save(answer);
    }

    /*Method to list all answer on database*/
    public List<Answer> listAll(){
        return answearRepository.findAll();
    }

    /*Method to find answer by id on database*/
    public Answer findById(Long id){
        return answearRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    /*Method to update answer on database*/
    public void update(Answer answer){
        answearRepository.save(answer);
    }

    /*Method to delete answer on database*/
    public void delete(Answer answer){
        answearRepository.delete(answer);
    }
}
