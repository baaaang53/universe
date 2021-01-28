package com.naver.book.springboot.config.auth;

import com.naver.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면 쓰기 위해서 해당 옵션들을 disabled 했다.
                .and()
                    .authorizeRequests()//URL별 권한 관리를 설정하는 옵션의 시작점. 얘가 선언되어야만 antMatchers들을 쓸 수 있다.
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 이 url은 user만 열람 가능하도록
                    .anyRequest().authenticated() // 설정된 url 외에 남은 url들. authenticated : 인증된(로그인한) 사용자들에게만.
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공시 메인 화면으로.
                .and()
                    .oauth2Login() // 로그인 기능에 대한 여러 설정의 진입점
                        .userInfoEndpoint()//로그인 성공 이후 사용자 정보 가져올 때 설정 담당
                            .userService(customOAuth2UserService); // 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록.
                                                                    // 리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
