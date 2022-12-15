package com.sparta.blog.entity;
// entity
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Post(PostRequestDto requestDto) {

        this.postTitle = requestDto.getPostTitle();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto) {
        this.postTitle = requestDto.getPostTitle();
        this.contents = requestDto.getContents();
    }
}