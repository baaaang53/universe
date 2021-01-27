package com.naver.book.springboot.web;

import com.naver.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 페이지에 관련된 컨트롤러는 모두 여기

@RequiredArgsConstructor
@Controller
public class IndexController {
//    @GetMapping("/")
//    public String index() { // 앞뒤로 알아서 붙어서 src/main/resources/templates/index.mustache가 된다.
//        return "index"; // 기본 8080에서 index.mastache를 호출하게 된 것.
//    }
//
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //얘는 이제 8080:posts/save가 되면 posts-save.mastache를 호출하는 것.
    }
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
}
