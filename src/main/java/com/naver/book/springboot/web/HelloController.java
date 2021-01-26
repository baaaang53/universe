package com.naver.book.springboot.web;

import com.naver.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다. 예전에(?) @Responsebody를 메소드마다 선언했던 걸 한 번에 사용할 수 있게 해주는 것.
public class HelloController {
    @GetMapping("/hello")  //GET의 요청을 받을 수 있는 API를 만들어준다.
    public String hello() {
        return "hello";
    }
    //이거는 지금 화면에 String을 출력한 거고

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) { // 외부에서 API로 넘긴 파라미터를 가져온다.
        return new HelloResponseDto(name, amount);
    }
    // 이거는 HelloResponseDto를 반환한 것. 이것도 데이터의 형태. 이렇게 적응하는 게 좋다.

    @GetMapping("/seungyeon")
    public String sy() {return "승연";}
    public String sy2() {return "이것도 나오나요?";} //안나옴. getmapping 하나당 하나.

}
