package com.shivam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.dao.GameDao;
import com.shivam.model.Game;

// This is an API. It only returns data in JSON/XML format, not a web page or a view like HTML or JSON

// In Spring MVC, @Controller handles requests and returns views (like HTML pages), 
// while @RestController handles requests and returns data directly, typically in JSON or XML, 
// simplifying the creation of RESTful APIs. 

// By Default, spring boot only supports returning JSON data using jackson library. We need extra configurations to return 
// XML data
	
// When using @RestController, we DO NOT NEED to annotate every method with @ResponseBody

// GET : Get data from app
// POST : Send/post data to app
// PUT : Update data in app
// DELETE : Delete data in app

//@Controller
@RestController
public class GameAPI {

	@Autowired
	private GameDao gameDao;
	
	// In MVC architecture, by default whenever a method is called, it will return a web page. That's what we have 
	// configured in application.properties using suffix and prefix. Since we are creating an API, we only need to return data, not a web page.
	// @ResponseBody lets the app know that only data is being returned, not a view.
	// Jackson dependency automatically converts data into JSON format
	// We can use 'produces' attribute to mention in which format to return data (json/xml etc)
	@GetMapping(path="games", produces= {"application/xml"})
	@ResponseBody
	public List<Game> getGames(){
		List<Game> games = gameDao.findAll();
		return games;
	}
	
	// @PathVariable is used by variable is present in the URL. It maps the variable in the URL to the method parameter.
	@GetMapping("game/{id}")
	@ResponseBody
	public Game getGame(@PathVariable("id") int id) {
		Game game = gameDao.findById(id).orElse(new Game(110,"newGame",0));
		return game;
	}
	
	// Spring allows different methods with same name/path if they have different REQUEST types, i.e. GET,POST,PUT etc. 
	@PostMapping("game")
	public String addGame(Game game) {
		gameDao.save(game);
		return "game added";
	}
}
