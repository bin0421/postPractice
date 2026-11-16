package com.back.domain.post.post.controller;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping("/api/v1/posts")
    @Transactional(readOnly = true)
    public List<Post> getItems() {
        return postService.findAll();
    }

    @GetMapping("/api/v1/posts/{id}")
    @Transactional(readOnly = true)
    public Post getItem(@PathVariable int id) {
        return postService.findById(id).get();
    }
}
