package com.naver.book.springboot.domain.user;

import com.naver.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) // JPA로 디비로 저장할 때, Enum 값을 어떤 형태로 저장할지 결정. 숫자로 저장되면 무슨 코드인지 모르니까 문자로하겠다.
    @Column(nullable = false)
    private Role role; // 이게 사용자의 권한을 관리하는 클래스로 만들어둔 것.

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() { // 관리자 key를 받아오는 메소드
        return this.role.getKey();
    }
}
