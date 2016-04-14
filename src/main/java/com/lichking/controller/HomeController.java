package com.lichking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/main")
	public String getHomePage(){
		return "front/home";
	}
	
	@RequestMapping("/address")
	public String getAddress(){
		return "front/address";
	}
	
}
