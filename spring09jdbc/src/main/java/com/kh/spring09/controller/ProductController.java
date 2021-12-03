package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.ProductDto;
import com.kh.spring09.repository.ProductDao;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "product/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ProductDto productDto) {
		
		productDao.insert(productDto);
		
		return "redirect:/";
	}
}
