package com.cunity.platform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HomeController {
	
	@RequestMapping("/index")
	public String home(HttpServletRequest request){
		System.out.println(".........index......");
		return "index";
	}
	
	/**
	 * 1. 使用ResquestMapping进行映射
	 * 通过prefix + returnVal + 后缀 来获取实际物理视图，然后会转发操作
	 * @return
	 */
	@RequestMapping("/HelloWorld")
	public String helloWorld(){
		System.out.println("helloWoldController");
		return "success";
	}

}
