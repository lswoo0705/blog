package com.sparta.blog.service;
// service
import com.sparta.blog.dto.PostRequestDto;
import com.sparta.blog.dto.PostResponseDto;
import com.sparta.blog.entity.Post;
import com.sparta.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {  // 데이터베이스와 연결을 위해 PostRepository를 사용할 수 있도록 추가
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();
        for (Post post : posts) {
            postResponseDtos.add(new PostResponseDto(post.getId(), post.getPostTitle(), post.getUsername(), post.getContents(), post.getCreatedAt()));
        }
        return postResponseDtos;
    }

    @org.springframework.transaction.annotation.Transactional
    public PostResponseDto getSelectedPosts(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post.getId(), post.getPostTitle(), post.getUsername(), post.getContents(), post.getCreatedAt());    // 패스워드 뺀 dto
    }

    @org.springframework.transaction.annotation.Transactional
    public String update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(    // id값에 해당하는 게시글이 있는지 확인
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")   // 예외처리
        );
        if (post.getPassword() == requestDto.getPassword()) {
            post.update(requestDto);    // 게시글이 있다면 업데이트
        } else {
            return "비밀번호가 일치하지 않습니다.";
        }
        return "수정 완료";
    }

    @org.springframework.transaction.annotation.Transactional
    public String deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword() == requestDto.getPassword()) {
            postRepository.deleteById(id);
        } else {
            return "비밀번호가 일치하지 않습니다.";
        }
        return "삭제 완료";
    }
}
