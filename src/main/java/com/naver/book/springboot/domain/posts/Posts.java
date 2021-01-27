package com.naver.book.springboot.domain.posts;

import com.naver.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스 // 기본값으로 클래스의 카멜케이스 일므을 언더스코어 네이밍으로 테이블 이름을 매칭합니다
public class Posts extends BaseTimeEntity {
    @Id // 해당 테이블의 Primary key 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성규칙. auto_increment
    private Long id; // 이게 PK

    @Column(length = 500, nullable = false) // 테이블의 칼럼. 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용. 문자열 사이즈를 500으로 늘리고싶거나, 타입을 text로 변경하고 싶으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자 역할. 생성 시점에 값을 채워주는 역할. 어느 필드에 어떤 값을 채워야하는지를 명확하게 알 수 있다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) { // 찐 업데이트 부분
        this.title = title;
        this.content = content;
    }
}
