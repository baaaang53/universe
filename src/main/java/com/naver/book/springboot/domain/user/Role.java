package com.naver.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"), // ROLE_GUEST 이게 권한 코드인 것.
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
