package com.kh.spring07;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring07.entity.StudentDto;

@Controller
public class HomeController {

	@RequestMapping("/")
//	public ModelAndView home() {
		public String home() {
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
		
		return "home";
	}
	
	
//////////////////////////////////////////////////////////
	// 주사위 1개
	@RequestMapping("/dice")
	public ModelAndView dice() {
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dice", dice);
		mv.setViewName("dice");
		
		return mv;
	}
	
	@RequestMapping("dice2")
	public String dice2(Model model) {
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		
		model.addAttribute("dice", dice);
//		return "/WEB-INF/views/dice.jsp";
		return "dice";
	}
	
	
//////////////////////////////////////////////////////////
	// 로또 번호 1개
	@RequestMapping("/lotto")
	public ModelAndView lotto() {
		Random r = new Random();
		int lotto = r.nextInt(45)+1;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("lotto", lotto);
		mv.setViewName("lotto");
		
		return mv;
	}
	
	@RequestMapping("lotto2")
	public String lotto2(Model model) {
		Random r = new Random();
		int lotto = r.nextInt(45)+1;
		
		model.addAttribute("lotto", lotto);
//		return "/WEB-INF/views/dice.jsp";
		return "lotto";
	}
	
	
//////////////////////////////////////////////////////////
	// 나이에 따른 지하철 요금
	@RequestMapping("/subway")
	public String subway(Model model, HttpServletRequest req) {
		
		int age = Integer.parseInt(req.getParameter("age"));
		int price;
		if(age >= 65 || age < 8) {
			price = 0;
		}
		else if(age >= 20) {
			price = 1250;
		}
		else if(age >= 14) {
			price = 720;
		}
		else {
			price = 450;
		}
		
		model.addAttribute("price", price);
		return "subway";
	}
	
	@RequestMapping("/subway2")
//	public String subway2(Model model, int age) {
//	public String subway(Model model, @RequestParam int age) {
	public String subway(Model model, 
			@RequestParam(required = false, defaultValue = "20") int age) {
		
		int price;
		if(age >= 65 || age < 8) {
			price = 0;
		}
		else if(age >= 20) {
			price = 1250;
		}
		else if(age >= 14) {
			price = 720;
		}
		else {
			price = 450;
		}
		
		model.addAttribute("price", price);
		return "subway";
	}
	
	// 스프링에서 제공하는 경로변수(Path variable) 방식
	// http://loacalhost:8080/spring07/subway3/20
	// ("/subway3/{age}") = {} 필수
	@RequestMapping("/subway3/{age}")
	public String subway3(Model model, @PathVariable int age) {
		int price;
		if(age >= 65 || age < 8) {
			price = 0;
		}
		else if(age >= 20) {
			price = 1250;
		}
		else if(age >= 14) {
			price = 720;
		}
		else {
			price = 450;
		}
		
		model.addAttribute("price", price);
		return "subway";
	}
	
		//객체에 해당하는 정보가 파라미터로 전달될 경우의 처리
		//ex - http://localhost:8080/spring07/add?name=피카츄&score=90
		//[1] request를 이용해서 수신하는 방법
		//[2] @RequestParam을 이용하여 수신하는 방법
		//		@RequestParam String name, @RequestParam int score
		//[3] @ModelAttribute 를 이용하여 수신하는 방법
		//		@ModelAttribute StudentDto studentDto
		//		받을 수 있는 항목을 다 찾아서 자료형까지 맞춰서 수신
	
	@RequestMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto, Model model) {
		model.addAttribute("studentDto", studentDto);
		return "add";
	}
	
}
