package com.sparta.blog.entity;

import com.sparta.blog.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Long userId;

    public Post(PostRequestDto requestDto, String username, Long userId) {
        this.postTitle = requestDto.getPostTitle();
        this.contents = requestDto.getContents();
        this.username = username;
        this.userId = userId;
    }

    public Post(PostRequestDto requestDto) {

    }

    public void update(PostRequestDto requestDto) {
        this.postTitle = requestDto.getPostTitle();
        this.contents = requestDto.getContents();
    }
}