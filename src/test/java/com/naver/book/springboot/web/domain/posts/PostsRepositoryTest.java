package com.naver.book.springboot.web.domain.posts;

import com.naver.book.springboot.domain.posts.Posts;
import com.naver.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트 끝나고 실행되는 메소드. 데이터 침범 막기 위해 사용 ㅍ ㅠ
    public void cleanup() {
        // 이게 after에 실행되는 함수
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 내가 저장하고싶은 것들 저장
                .author("baaaang_53")
                .content(content)
                .title(title)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 저장되어있는 거 다 불러오기

        //then
        Posts posts = postsList.get(0); // 0번 게시글 불러오기
        assertThat(posts.getTitle()).isEqualTo(title); // 저장하려는 제목 제대로 됐는지
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
