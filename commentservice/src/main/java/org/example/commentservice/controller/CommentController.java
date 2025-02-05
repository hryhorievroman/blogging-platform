package org.example.commentservice.controller;

import jakarta.ws.rs.POST;
import org.example.commentservice.model.Comment;
import org.example.commentservice.repo.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentRepository commentRepository;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPostId(@RequestParam("postId") Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
