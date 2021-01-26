package com.naver.book.springboot.web;

import com.naver.book.springboot.service.posts.PostsService;
import com.naver.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // Post 요청이 있을때 아래 함수를 실행한다.
    public Long save(@RequestBody PostsSaveRequestDto requestDto) { // 외부에서 받아온 requestDto를
        return postsService.save(requestDto); // 저장
    }
}
