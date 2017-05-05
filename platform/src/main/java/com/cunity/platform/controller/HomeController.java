package com.cunity.platform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
	
	@RequestMapping("/index")
	public String home(HttpServletRequest request){
		System.out.println(".........index......");
		return "index";
	}

}
