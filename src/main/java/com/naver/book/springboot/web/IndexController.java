package com.naver.book.springboot.web;

import com.naver.book.springboot.config.auth.dto.SessionUser;
import com.naver.book.springboot.service.posts.PostsService;
import com.naver.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

// 페이지에 관련된 컨트롤러는 모두 여기

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index() { // 앞뒤로 알아서 붙어서 src/main/resources/templates/index.mustache가 된다.
//        return "index"; // 기본 8080에서 index.mastache를 호출하게 된 것.
//    }
//
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc()); // 모든 데이터 가져다가 넘겨줌
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); // 로그인 성공시 세션에 SessionUser를 저장하도록.

        if (user != null) { // 세션에 저장된 값이 있을 때에만 model에 userName으로 등록. 아무도 없으면 로그인 버튼만 보인다.
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //얘는 이제 8080:posts/save가 되면 posts-save.mastache를 호출하는 것.
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id); // 해당하는 게시글을 가져다가
        model.addAttribute("post", dto); // 같이 넘겨줌

        return "posts-update";
    }



}
