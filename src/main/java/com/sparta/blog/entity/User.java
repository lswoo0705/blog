package com.sparta.blog.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 10)
    @Pattern(regexp = "^[0-91-z]*$",message = "최소 4자, 최대 10자 영어 소문자와 소문자만 입력할 수 있습니다.")
    @Column(nullable = false, unique = true) // 빈칸 안됨, 중복 불가능
    private String username;

    @Size(min = 8, max = 15)
    @Pattern(regexp = "^[^\\t\\r\\n\\v\\f]*$",message = "최소 8자, 최대 15자 영어와 숫자만 입력할 수 있습니다.")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
