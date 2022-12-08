package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {   // 클라이언트를 통해 받아오는 요청을 이 객체를 통해 전달한다.
    private Long id;
    private String postTitle;
    private String username;
    private String contents;
    private int password;
}
