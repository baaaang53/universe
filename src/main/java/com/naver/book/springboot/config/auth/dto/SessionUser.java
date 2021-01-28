package com.naver.book.springboot.config.auth.dto;

import com.naver.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

//SessionUser에는 인증 사용자 정보만 필요로한다. 그래서 저 세개의 필드만 있으면 됨.