package com.example.FirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//먼저 Controller를 선언한다.
@Controller
public class FirstController {

    //URL 요청연결이 없으면 작동을 안한다, 괄호안에 접속할 URL주소를 넣어줘야 한다.
    //localhost:8080/hi　→　greetings.mustache
    @GetMapping("hi") // 괄호안의 URL을 입력받았을때 return을 반환한다.
    //메소드
    public String NiceToMeetYou(Model model) {
        model.addAttribute("username", "Yo");
        //return 응답페이지 설정, templates/greetings.mustache를 찾아서 브라우저로 전송함!
        return "greetings";
    }

    @GetMapping("bye")
    public String SeeYouNext(Model model) {
        model.addAttribute("nickname", "Yi");
        return "goodbye";
    }
}
