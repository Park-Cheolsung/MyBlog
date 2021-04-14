package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class BoardController {

	@GetMapping("/")
	public String index() {
		
		System.out.println(this.getClass().getName() + " -> start.");
		// "/WEB-INF/jsp/User/index.jsp"
		return "index";
	}
}
