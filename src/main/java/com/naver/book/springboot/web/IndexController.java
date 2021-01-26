package com.naver.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() { // 앞뒤로 알아서 붙어서 src/main/resources/templates/index.mustache가 된다.
        return "index";
    }
}
