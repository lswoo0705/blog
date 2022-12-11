package com.sparta.blog.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostResponseDto {
    private Long id;
    private String postTitle;
    private String username;
    private String contents;
    private LocalDate createdAt;

    public PostResponseDto(Long id, String postTitle, String username, String contents, LocalDate createdAt) {
        this.id = id;
        this.postTitle = postTitle;
        this.username = username;
        this.contents = contents;
        this.createdAt = createdAt;
    }
}
