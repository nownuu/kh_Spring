package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.spring08.entity.StudentDto;
import com.kh.spring08.repository.StudentDao;

@Controller
public class StudentController {
	
// 등록 절차
// = 반드시 입력페이지와 처리페이지가 존재한다.
// = 주소를 맞추고 GET/POST 로 구분해서 처리한다.
	
//@RequestMapping("/insert") - 모든 방식
//@RequestMapping(value="/insert", method=RequestMethod.GET) - GET 방식(~spring 4.x)
//@RequestMapping(value="/insert", method=RequestMethod.POST) - POST방식(~spring 4.x)
	
	@GetMapping("/insert") //get 방식
	public String insert() {
		// 해야할 일 : 입력 페이지로 연결
		return "insert";
	}
	
	@PostMapping("/insert") //post 방식
	public String insert(@ModelAttribute StudentDto studentDto) throws Exception {
		// 해야할 일 : 데이터를 받아서 처리한 뒤 다른 곳으로 안내
		// DB 접속 및 등록코드
		
		StudentDao studentDao = new StudentDao();
		studentDao.insert(studentDto);
		return "insert_success";
	}
}
