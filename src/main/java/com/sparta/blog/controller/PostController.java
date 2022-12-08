package com.sparta.blog.controller;
// 게시글 페이지를 반환하는 기능

import com.sparta.blog.dto.PostRequestDto;
import com.sparta.blog.entity.Post;
import com.sparta.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;  // 포스트서비스와 연결

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }
}
