 package org.generation.italy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String getHome() {
		
		return "homePage";
	}
	
	@GetMapping("/user")
	public String getUser() {
		
		return "home/index";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		
		return "home/index";
	}
	
	@GetMapping("/useradmin")
	public String getUserAdmin() {
		
		return "home/index";
	}
}