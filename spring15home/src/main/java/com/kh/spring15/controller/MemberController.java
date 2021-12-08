package com.kh.spring15.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring15.entity.MemberDto;
import com.kh.spring15.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		//회원정보 단일조회 및 비밀번호 일치판정
		MemberDto findDto = memberDao.login(memberDto);
		if(findDto != null) {
			//세션에 ses, grade를 설정하고 root로 리다이렉트
			session.setAttribute("ses", findDto.getMemberId());
			session.setAttribute("grade", findDto.getMemberGrade());
			return "redirect:/";
		}
		else {
			//로그인 페이지에 오류 표시와 함께 리다이렉트
			//return "redirect:/member/login?error";//절대
			return "redirect:login?error";//상대
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("ses");
		session.removeAttribute("grade");
		//session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String join() {
//		return "/WEB-INF/views/member/join.jsp";
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.join(memberDto);
//		return "redirect:/member/join_success";
		return "redirect:join_success";
	}
	
	@RequestMapping("/join_success")
	public String joinSuccess() {
//		return "/WEB-INF/views/member/join_success.jsp";
		return "member/join_success";
	}
	
	//내정보
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("ses");
		MemberDto memberDto = memberDao.get(memberId);
		model.addAttribute("memberDto", memberDto);
//		return "/WEB-INF/views/member/mypage.jsp";
		return "member/mypage";
	}
}