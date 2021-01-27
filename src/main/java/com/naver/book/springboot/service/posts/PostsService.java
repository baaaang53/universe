package com.naver.book.springboot.service.posts;

import com.naver.book.springboot.domain.posts.Posts;
import com.naver.book.springboot.domain.posts.PostsRepository;
import com.naver.book.springboot.web.dto.PostsListResponseDto;
import com.naver.book.springboot.web.dto.PostsResponseDto;
import com.naver.book.springboot.web.dto.PostsSaveRequestDto;
import com.naver.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id) // 해당 게시글을 불러와서
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. Id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent()); // 업데이트

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. Id = " + id));
        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. Id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되, 조회만 가능하게 해서 조회 속도가 개선됨.
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDto(posts)) // postRepository 결과로 넘어온 Posts의 stream을 map을 통해 PostsListResponseDto로 변환->List로 변환
                .collect(Collectors.toList());
    }
}
