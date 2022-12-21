package com.sparta.blog.controller;
// 게시글 페이지를 반환하는 기능
import com.sparta.blog.dto.PostRequestDto;
import com.sparta.blog.dto.PostResponseDto;
import com.sparta.blog.entity.Post;
import com.sparta.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    Post post = new Post();

    private final PostService postService;  // 포스트서비스와 연결

    // 게시글 작성
    @PostMapping
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 전체 게시글 조회하기
    @GetMapping
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    // 선택 게시글 조회하기
    @GetMapping("/{id}")
    public PostResponseDto getSelectedPosts(@PathVariable Long id) {
        return postService.getSelectedPosts(id);
    }

    // 게시글 수정하기
    @PutMapping("/{id}")  // id값을 받아와서 그 게시글을 수정.   어떤 내용을 수정할건지 받아와야함.
    public String updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    // 게시글 삭제하기
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id,  @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(id, requestDto);
    }
}