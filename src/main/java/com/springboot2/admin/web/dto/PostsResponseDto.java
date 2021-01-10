package com.springboot2.admin.web.dto;

import com.springboot2.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    public Long id;
    private  String title;
    private  String content;
    private  String author;

    public PostsResponseDto(Posts entity){
        this.id      = entity.getId();
        this.title   =  entity.getTitle();
        this.content = entity.getContent();
        this.author  = entity.getAuthor();
    }



}
