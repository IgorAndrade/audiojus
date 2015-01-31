package br.com.audiojus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("LoginController")
@RequestMapping("/login")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		
		return "login/login";
	}
}
