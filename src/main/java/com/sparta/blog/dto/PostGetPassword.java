package com.sparta.blog.dto;

import lombok.Getter;

@Getter
public class PostGetPassword {
    private int password;

    public PostGetPassword(int password) {  // DB에 저장되어있던 password
        this.password = password;
    }
}
