package com.kh.spring07;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
}
