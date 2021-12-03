package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/join") //입력 페이지로 감
	public String join() {
		return "member/join"; //입력 페이지 주소 - member 내의 join
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		
		// DB 등록 코드
		
		
		return "member/join_success"; //결과 페이지
	}
}
