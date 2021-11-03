package com.spring.mvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//역할 : 브라우저의 요청 처리
@Controller
@Log4j2 // 로그를 만들어주는 기능
public class BasicController {
    // 요청 처리 메서드
//    @RequestMapping(value = "/req/hello", method = RequestMethod.GET)
    @GetMapping("/req/hello")
    public String hello() {
        // 비즈니스 로직
        System.out.println("안녕안녕");
        // 화면 연결 : 2가지 방법
        /*
        * 1. redirect 재요청
        * 2.forward 단순한 파일열기
        */
//        return "redirect:/s-login-form";
        // forward시에는 열어야 할 jsp의 경로를 문자열로 입력
        return "s-from";
    }
    // 사용자의 요청 URI : /req/ex
    // 응답시에 views폴더 아래에 req_ex폴더 아래에 있는 v1.jsp 파일 실행

    @GetMapping("/req/ex")
    public String ex() {
        return "req_ex/v1";
    }

    @GetMapping("/req/v1")
    public String v1Get() {
        log.info("/req/v1 GET!");
        return "req_ex/v1";
    }
    // 요청 파라미터 얻기 : 클라이언트에서 서버로 전송된 데이터
    // www.abc.com/req/v1?pet=puppy&kind=bulldog
    // 1. HttpServletRequest 객체 활용하기
    @PostMapping("/req/v1")
    public String v1Post(HttpServletRequest request) {
        log.info("/req/v1 POST!");
        String petName = request.getParameter("pet");
        String age = request.getParameter("age");
        int ageNum = Integer.parseInt((age));
        log.info("선택한 동물: " + petName);
        log.info(petName = " 의 내년 나이는 " + (ageNum + 1) + "살입니다.");
        return "req_ex/v1";
    }

    // 2.@RequestParam 이용하기
    // form양식의 name값과 동일한 변수값 생성
    // RequestParam을 필수 명시해야할 경우는 변수명이 다른 지역변수로 선점되어 중복을 피해야할 경우
    // RequestParam을 선언하고 일치
    @PostMapping("/req/v2")
    public String v2(@RequestParam("pet") String pet1, int age) {
        String pet = "하하";
        log.info(String.format("%s의 작년 나이는 %d살입니다." ,pet1 ,age - 1));

        return "req_ex/v1";
    }

    // 3.커맨트객체 활용하기
    @PostMapping("/req/v3")
    public String v3(Pet petInfo) {
        log.info(petInfo);

        return "req_ex/pet_info";
    }

    // 화면(view)으로 서버데이터 전송
    // 서버에서 클라이언트화면으로 데이터를 보낼 땐 Model 객체를 활용
    @GetMapping("/req/v4")
    public String v4(Model model) {
        String[] foods = {"짜장면", "볶음밥", "돈까스", "삼겹살", "햄버거"};
        int rn = (int) (Math.random() * foods.length);
        model.addAttribute("f",foods[rn]);
        model.addAttribute("foods", foods);
        return "req_ex/result";
    }


}
