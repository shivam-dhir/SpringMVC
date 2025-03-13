package com.shivam.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session) {
		int res = num1 + num2;
		session.setAttribute("res", res);
		return "add.jsp"; 
	}
	
}
