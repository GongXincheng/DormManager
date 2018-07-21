package com.gxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 显示页面
 * @author 宫新程
 */
@Controller
public class PageController {

	@RequestMapping("/page/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/page/{role}/{page}")
	public String showPage(@PathVariable String page,@PathVariable String role){
		return role + "/" + page;
	}
	
	@RequestMapping("/index")
	public String showPage(){
		return "index";
	}
	
}
