package com.sparta.blog.controller;

import com.sparta.blog.dto.BlogResponseDto;
import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.dto.DeleteBlogDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @Transactional
    @PostMapping("/post")
    public BlogResponseDto saveBlog(@RequestBody BlogRequestDto blogRequestDto) {     //객체형식으로 넘어오기 때문에 requestbody씀
        return blogService.saveBlog(blogRequestDto);
    }

    @Transactional
    @GetMapping("/posts")
    public List<BlogResponseDto> getBlog() {
        return blogService.getBlog();
    }

    @Transactional
    @GetMapping("/post/{id}")
    public BlogResponseDto getBlog(@PathVariable Long id) {
        return blogService.getBlog(id);
    }

    @Transactional
    @PutMapping("/post/{id}")
    public BlogResponseDto putBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogRequestDto) {
        return blogService.putBlog(id, blogRequestDto);
    }

    @Transactional
    @DeleteMapping("/post/{id}")
    public DeleteBlogDto deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto blogRequestDto){
        return blogService.deleteBlog(id, blogRequestDto);
    }
}