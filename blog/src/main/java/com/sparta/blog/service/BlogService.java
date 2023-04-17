package com.sparta.blog.service;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.dto.BlogResponseDto;
import com.sparta.blog.dto.DeleteBlogDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;                 // 싱글톤이어야하기 때문!

    @Transactional
    public BlogResponseDto saveBlog(BlogRequestDto blogRequestDto) {
        Blog blog = new Blog(blogRequestDto);       //데이터베이스에 연결해서 저장하려면 @Entity어노테이션이 걸려져있는 Board클래스를 인스턴스로 만들어서 그 값을사용해서 저장해야 함. 그렇기때문에 board 객체를 만들어주고 생성자를 사용해서 값들을 넣어줘야 함.
        blogRepository.save(blog);
        return new BlogResponseDto(blog);


    }

    public List<BlogResponseDto> getBlog() {
        List<Blog> blogList = blogRepository.findAllByOrderByModifiedAtDesc();
        List<BlogResponseDto> blogResponseDto = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogResponseDto blogResponseDto1 = new BlogResponseDto(blog);
            blogResponseDto.add(blogResponseDto1);
        }
        return blogResponseDto;
    }

    public BlogResponseDto getBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 글입니다")
        );
        return new BlogResponseDto(blog);
    }

    @Transactional
    public BlogResponseDto putBlog(Long id, BlogRequestDto blogRequestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 글입니다")
        );
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);

        if (blogRequestDto.getPassword().equals(blog.getPassword())) {
            blog.update(blogRequestDto);
            return blogResponseDto;
        } else {
            return blogResponseDto;
        }
    }

    public DeleteBlogDto deleteBlog(Long id, BlogRequestDto blogRequestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 글입니다")
        );
        DeleteBlogDto deleteBlogDto = new DeleteBlogDto();
        if (blogRequestDto.getPassword().equals(blog.getPassword())) {
            blogRepository.deleteById(id);
            deleteBlogDto.setMsg("success");
        } else {
            deleteBlogDto.setMsg("fail");
        }
        return deleteBlogDto;
    }


}
