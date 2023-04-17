package com.sparta.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogRequestDto {
    private String title;
    private String content;
    private String creator;
    private String password;
}