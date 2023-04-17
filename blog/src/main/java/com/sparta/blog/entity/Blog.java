package com.sparta.blog.entity;

import com.sparta.blog.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String creator;
    private String password;



    public Blog(BlogRequestDto blogRequestDto){
        this.creator=blogRequestDto.getCreator();
        this.title=blogRequestDto.getTitle();
        this.content=blogRequestDto.getContent();
        this.password=blogRequestDto.getPassword();
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.creator = blogRequestDto.getCreator();
        this.content = blogRequestDto.getContent();
        this.title = blogRequestDto.getTitle();
    }



}
