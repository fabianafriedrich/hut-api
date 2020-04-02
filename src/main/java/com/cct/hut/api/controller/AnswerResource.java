package com.cct.hut.api.controller;

import com.cct.hut.api.model.Answer;
import com.cct.hut.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*Controller/Resources Layer to handle all the request that come from the UI*/
@RestController
@RequestMapping(value = "/answers")
public class AnswerResource {
    /*Spring Dependence Injection */
    @Autowired
    private AnswerService answerService;

    /*HTTP get methods to list all the results*/
    @GetMapping
    public List<Answer> getAll(){
        return answerService.listAll();
    }

    /*HTTP post methods to persist answer*/
    @PostMapping
    public ResponseEntity<Answer> add(@RequestBody @Valid Answer answer){
        answerService.save(answer);
        return new ResponseEntity<Answer>(answer, HttpStatus.CREATED);
    }

    /*HTTP get methods to list by id the results*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id){
        Answer answer = answerService.findById(id);
        return ResponseEntity.ok(answer);
    }

    /*HTTP put method to update answer*/
    @PutMapping
    public ResponseEntity update(@RequestBody @Valid Answer answer) {
        answerService.update(answer);
        return new ResponseEntity<Answer>(answer, HttpStatus.CREATED);
    }

    /*HTTP Delete method to remove answer by id*/
    @DeleteMapping (value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        answerService.delete(answerService.findById(id));
        return new ResponseEntity<Answer>(HttpStatus.OK);
    }
}
