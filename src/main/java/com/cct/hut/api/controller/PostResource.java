package com.cct.hut.api.controller;

import com.cct.hut.api.model.Post;
import com.cct.hut.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*Controller/Resources Layer to handle all the request that come from the UI*/
@RestController
@RequestMapping(value = "/posts")
public class PostResource {


    /*Spring Dependence Injection */
    @Autowired
    private PostService postService;

    /*HTTP get methods to list all the results*/
    @GetMapping
    public List<Post> getAll(){
        return postService.listAll();
    }

    /*HTTP post methods to persist post*/
    @PostMapping
    public ResponseEntity<Post> add(@RequestBody @Valid Post post){
        postService.save(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    /*HTTP get methods to list by id the results*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        Post post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    /*HTTP put method to update post*/
    @PutMapping
    public ResponseEntity update(@RequestBody @Valid Post post) {
        postService.update(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    /*HTTP Delete method to remove post by id*/
    @DeleteMapping (value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        postService.delete(postService.findById(id));
        return new ResponseEntity<Post>(HttpStatus.OK);
    }
}
