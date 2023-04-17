package com.sparta.blog.dto;

import com.sparta.blog.entity.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteBlogDto {
    private String msg;


    public void setMsg(String msg) {
        this.msg = msg;
    }
}
