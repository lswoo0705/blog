package com.sparta.blog.service;

import com.sparta.blog.dto.PostRequestDto;
import com.sparta.blog.entity.Post;
import com.sparta.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(    // id값에 해당하는 게시글이 있는지 확인
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")   // 예외처리
        );

    }
}
