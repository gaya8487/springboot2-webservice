package com.springboot2.admin.web;

import com.springboot2.admin.service.posts.PostService;
import com.springboot2.admin.web.dto.PostsResponseDto;
import com.springboot2.admin.web.dto.PostsSaveRequestDto;
import com.springboot2.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){

        return  postService.update(id,requestDto);

    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){

        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete(@PathVariable Long id){
        postService.delete(id);
        return id;

    }

}
