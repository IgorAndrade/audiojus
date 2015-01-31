package br.com.audiojus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class Teste {
	
	@RequestMapping( method = RequestMethod.GET)
	public String teste(){
		return "teste";
	}
}
