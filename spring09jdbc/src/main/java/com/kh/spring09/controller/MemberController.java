package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.MemberDto;
import com.kh.spring09.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join") //입력 페이지로 감
	public String join() {
		return "member/join"; //입력 페이지 주소 - member 내의 join
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		
		// DB 등록 코드
		memberDao.join(memberDto);
		
		// 등록을 마치고 JSP를 연결(forward,  포워드)하면 새로고침에 속수무책으로 당한다.
		
		// 새로고침을 대비해서 이 기능이 다시 실행되지 않도록 다른 기능으로 강제 이동(redirect)
		// = redirect:로 시작하는 주소를 반환
		return "redirect:/"; //root 페이지로 리다이렉트(뷰리졸버 무시)
	}
}
