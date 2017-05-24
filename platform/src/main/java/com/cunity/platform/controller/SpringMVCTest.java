package com.cunity.platform.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cunity.platform.model.User;

@SessionAttributes(value={"user"}, types={String.class})
@Controller
@RequestMapping("/testSpringMVC")
public class SpringMVCTest {
	
	private static final String SUCCSS = "success";
	
	@ResponseBody
	@RequestMapping("/testJson")
	public User testJson(){
		User user = new User();
		user.setUsername("hdy");
		user.setPassword("123456");
		return user;
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println(".................redirect:testSpringMVC.jsp.............");
		return "redirect:home";
	}
	
	
	@RequestMapping("/excelView")
	public String excelView(){
		System.out.println(".....................excelView..........");
		return "viewExcel";
	}
	
	@RequestMapping("/helloView")
	public String helloView(){
		System.out.println(".....................helloView..........");
		return "helloView";
	}

	/**
	 * 测试SessionAttribute注解
	 * 作用： 将属性值放在了RequestScope和SessionScope当中
	 * 方法： (1) 通过value值(即map的key名字的数组来明确需要添加的属性值)
	 * 		 (2) 通过type值(即map的value的Class类型来设置需要添加的属性值)
	 * 注意： @SessionAttribute的注解只能作用于类上，不能作用于方法上
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map){
		User user = new User();
		user.setUsername("Mike");
		user.setPassword("123456");
		map.put("user",user);
		map.put("name", "Mike");
		return SUCCSS;
	}
	
	/**
	 * Request使用Map来传递Model的值，与ModelAndView的效果一致
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map){
		map.put("names", Arrays.asList("Tom","Bob","Mike"));
		return SUCCSS;
	}
	
	/**
	 * Request使用ModelAndView传递参数值
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String name = SUCCSS;
		ModelAndView mv = new ModelAndView(name);
		mv.addObject("time", new Date());
		return mv;
	}
	
	/**
	 * 1. SpringMVC 自动为POJO装填属性值
	 * 2. 支持级联属性
	 * @param user
	 * @return
	 */
	@RequestMapping("testPOJO")
	public String testPOJO(User user){
		System.out.println("user="+user.toString());
		return SUCCSS;
	}
	
	@RequestMapping("/home")
	public String test(){
		System.out.println("testRequestMappingHome");
		return "testSpringMVC";
	}
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping");
		return SUCCSS;
	}	
	
	
	/**
	 * 测试 RequestMapping method的测试(GET和POST的区别)
	 * @return
	 */
	@RequestMapping(value="/testRequestMethod", method=RequestMethod.POST)
	public String testRequestMethod(){
		System.out.println("testRequestMethod");
		return SUCCSS;
	}
	
	
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="id", required=false, defaultValue="1") int id){
		System.out.println("testRequestParam username="+username 
				+ " , id=" + id);
		return SUCCSS;
	}
	
	
	/**
	 * 测试REST
	 * ---------
	 * REST： 即
	 * /order/1 HTTP GET:    得到ID=1的order
	 * /order/1 HTTP DELETE: 删除ID=1的order
	 * /order/1 HTTP PUT:    更新ID=1的order
	 * /order/  
	 * ---------
	 */
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.GET)
	public String testRest(@PathVariable Integer id){
		System.out.println("testRest GET: " + id);
		return SUCCSS;
	}
	
	@RequestMapping(value="/testRest", method=RequestMethod.POST)
	public String testRestPost(){
		System.out.println("testRest POST: ");
		return SUCCSS;
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.DELETE)
	@ResponseBody()
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("testRest DELETE: " + id);
		return "testRest DELETE SUCCESS";
	}
	
	@RequestMapping(value="/testRest/{id}", method=RequestMethod.PUT)
	@ResponseBody()
	public String testRestPut(@PathVariable Integer id){
		System.out.println("testRest Put: " + id);
		return "testRest PUT SUCCESS";
	}
	
	

	

	
	
}
