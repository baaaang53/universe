package com.naver.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 이렇게 하면 기본적인 CRUD 메소드 생성됨.
}
