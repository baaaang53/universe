package com.naver.book.springboot.web;

import com.naver.book.springboot.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith(SpringExtension.class)
//@WebMvcTest
@WebMvcTest(controllers = HelloController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
})
//@WebMvcTest(controllers = HelloController.class)    // web에 집중하는 annot. @Controller를 사용할 수 있도록.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹 API 테스트할 때 사용. 스프링 mvc 테스트의 시작점. 이걸로 HTTP GET, POST 등에 대한 테스트 가능

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String answer = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(answer));
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name) // 넘겨주는 API에서 변수 이름. @RequestParam으로 받아오는 게 이 부분
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // 제대로 넘어갔는지를 확인하는 부분!@!@!!!!!
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
