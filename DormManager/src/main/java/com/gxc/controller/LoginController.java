package com.gxc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxc.entity.TAdmin;
import com.gxc.entity.TDormmanager;
import com.gxc.entity.TStudent;
import com.gxc.service.LoginService;
import com.gxc.utils.MyResult;

/**
 * 用户登录
 * @author 宫新程
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param yanzhengma
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public MyResult login(String username,String password, String yanzhengma,
			int role,HttpServletRequest request){
		
		//判断验证码是否正确
		String yzm = (String)request.getSession().getAttribute("yzm");
		if(!yzm.equalsIgnoreCase(yanzhengma)){
			return MyResult.build(201, "验证码错误！");
		}
		
		//登录验证
		MyResult result = loginService.login(username,password,role);

		//登录成功后，将用户，role放入Session中
		request.getSession().setAttribute("loginUser", result.getData());
		request.getSession().setAttribute("loginRole", role);
		return result;
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/exitSystem")
	public String exitSystem(HttpServletRequest request){
		//清除sessin
		request.getSession().removeAttribute("loginUser");
		request.getSession().invalidate();
		//跳转到登录页面
		return "redirect:/page/login.html";
	}
	
	/**
	 * 更新密码(超级管理员)
	 * @param oldPassword
	 * @param newPassword
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/changePassword")
	@ResponseBody
	public MyResult updatePassword1(String oldPassword, String newPassword, HttpServletRequest request){
		//从Session中获取loginUser
		TAdmin admin = (TAdmin)request.getSession().getAttribute("loginUser");
		MyResult result = loginService.updatePassword(oldPassword,newPassword,admin);
		return result;
	}
	/**
	 * 更新密码(宿管员)
	 * @param oldPassword
	 * @param newPassword
	 * @param request
	 * @return
	 */
	@RequestMapping("/dorm/changePassword")
	@ResponseBody
	public MyResult updatePassword2(String oldPassword, String newPassword, HttpServletRequest request){
		//从Session中获取loginUser
		TDormmanager dormManager = (TDormmanager)request.getSession().getAttribute("loginUser");
		MyResult result = loginService.updatePassword(oldPassword,newPassword,dormManager);
		return result;
	}
	
	/**
	 * 更新密码(学生)
	 * @param oldPassword
	 * @param newPassword
	 * @param request
	 * @return
	 */
	@RequestMapping("/stu/changePassword")
	@ResponseBody
	public MyResult updatePassword3(String oldPassword, String newPassword, HttpServletRequest request){
		//从Session中获取loginUser
		TStudent student = (TStudent)request.getSession().getAttribute("loginUser");
		MyResult result = loginService.updatePassword(oldPassword,newPassword,student);
		return result;
	}
	
}












