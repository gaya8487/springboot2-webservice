package com.springboot2.admin.web;

import com.springboot2.admin.service.posts.PostService;
import com.springboot2.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        //Model  템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        //postService.findAllDesc()로 가져온 결과를 posts로 index.muistache에 전달합니다.
        model.addAttribute("posts",postService.findAllDesc());
        return "index";

    }

    @GetMapping("/posts/save")
    public String postsSave(){

        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){

         PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
