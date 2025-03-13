package com.shivam.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	// request mapping allows to fetch parameters from HttpServletRequest object
	public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		
		// ModelAndView is an MVC concept to reduce configurations. It is used instead of HttpSession in this case.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add.jsp");
		
		int res = num1 + num2; 
		mv.addObject("res", res);
		
		return mv; 
	}
	
}
