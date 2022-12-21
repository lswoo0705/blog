package com.sparta.blog.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostResponseDto {
    private String postTitle;
    private String contents;
    private LocalDate createdAt;
    private String username;

    public PostResponseDto(String postTitle, String contents, LocalDate createdAt, String username) {
        this.postTitle = postTitle;
        this.contents = contents;
        this.createdAt = createdAt;
        this.username = username;
    }
}
