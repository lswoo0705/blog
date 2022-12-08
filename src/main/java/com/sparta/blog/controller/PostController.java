package com.sparta.blog.controller;
// 게시글 페이지를 반환하는 기능

import com.sparta.blog.dto.PostRequestDto;
import com.sparta.blog.entity.Post;
import com.sparta.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    Post post = new Post();

    private final PostService postService;  // 포스트서비스와 연결

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PutMapping("/api/posts/{id}")  // id값을 받아와서 그 게시글을 수정.   어떤 내용을 수정할건지 받아와야함.
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
