package com.shivam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.dao.GameDao;
import com.shivam.model.Game;

@Controller
public class HomeController {
	
	@Autowired
	private GameDao gameDao;
	
	// ModelAttribute is used to assign variables/ objects beforehand
	@ModelAttribute
	public void assignName(ModelMap mm) {
		mm.addAttribute("name", "Shivam");
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home page invoked");
		return "index";
	}
	
	// RequestParam allows to fetch parameters from HttpServletRequest object
	// Replaces RequestMapping with PostMapping, as RequestMapping also accepts Get requests, which might be triggered when
	// refreshing the page and adds an empty Game object into the DB.
	@PostMapping("add")
	public String add(@ModelAttribute("games") Game game) {
		
// 		ModelAndView is an MVC concept to reduce configurations. It is used instead of HttpSession in this case.
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("add");
//		mv.addObject("res", res);
//		mm.addAttribute("res", res);
		
		gameDao.save(game);
		return "thankyou";  
	}
	
	@RequestMapping("getGameById")
	public String getGameById(@RequestParam int id, ModelMap mm) {
		Game game = gameDao.getOne(id);
		mm.addAttribute("game", game);
		return "getGame";
	}
	
	@RequestMapping("getGameByName")
	public String getGameByName(@RequestParam String name, ModelMap mm) {
		// findByName is a function created by me, but functionality is given by JpaRepository interface. 
		// check out GameDao.java file to understand functionality
		//List<Game> games = gameDao.findByNameOrderByMetascoreDesc(name);
		
		// find() method uses custom written query
		List<Game> games = gameDao.find(name);
		mm.addAttribute("game", games);
		return "getGame";
	}
	
	@RequestMapping("showGames")
	public String showGames(ModelMap mm) {
		List<Game> games = gameDao.findAll();
		mm.addAttribute("games", games);
		return "showGames";
	}
	
}
