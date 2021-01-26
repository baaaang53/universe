package com.naver.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // 이걸로 인해 스프링부트의 자동 설정, 스프링 Bean 읽기, 생성 모두 자동으로 설정 됨. // 이 아래부터 설정을 읽기 때문에, 프로젝트 최상단에 위치
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS(서버)를 실행. 서버에 톰캣 설치 필요 없음. 스프링부트로 만들어진 Jar 파일로 실행하면 됨. 언제 어디서나 같은 환경에서 스프링부트를 배포할 수 있음
    }
}
