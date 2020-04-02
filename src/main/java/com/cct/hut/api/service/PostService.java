package com.cct.hut.api.service;

import com.cct.hut.api.model.Post;
import com.cct.hut.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PostService {
    /*Spring Dependence Injection */
    @Autowired
    private PostRepository postRepository;

    /*Method to save post on database*/
    public Post save(Post post){
        return postRepository.save(post);
    }

    /*Method to list all post on database*/
    public List<Post> listAll(){
        return postRepository.findAll();
    }

    /*Method to find post by id on database*/
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
    /*Method to update post on database*/
    public void update(Post post){
        postRepository.save(post);
    }

    /*Method to delete post on database*/
    public void delete(Post post){
        postRepository.delete(post);
    }

}
