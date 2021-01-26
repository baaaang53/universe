package com.naver.book.springboot.web;

import com.naver.book.springboot.service.posts.PostsService;
import com.naver.book.springboot.web.dto.PostsResponseDto;
import com.naver.book.springboot.web.dto.PostsSaveRequestDto;
import com.naver.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    //게시글 등록
    @PostMapping("/api/v1/posts") // Post 요청이 있을때 아래 함수를 실행한다.
    public Long save(@RequestBody PostsSaveRequestDto requestDto) { // 외부에서 받아온 requestDto를
        return postsService.save(requestDto); // 저장
    }

    //게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //게시글 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
