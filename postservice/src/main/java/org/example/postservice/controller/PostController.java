package org.example.postservice.controller;

import org.example.postservice.model.Post;
import org.example.postservice.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        return postRepository.findByUserId(userId);
    }
}
