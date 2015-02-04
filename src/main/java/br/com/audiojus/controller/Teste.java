package br.com.audiojus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Teste {
	

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(){
		return "teste";
	}
}
