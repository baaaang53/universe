package com.naver.book.springboot.web.dto;

import com.naver.book.springboot.domain.posts.Posts;
import lombok.Getter;

// 게시글 조회했을 때 Dto
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) { // 따로 builder 안 쓰고 그냥 entity 받아서 값 넣음. 생성자 필요 없어
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
