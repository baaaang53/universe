package com.naver.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 이렇게 하면 기본적인 CRUD 메소드 생성됨.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // 제공되지 않는 메소드는 이렇게 직접 쿼리를 써주면 된다.
    List<Posts> findAllDesc();
}
