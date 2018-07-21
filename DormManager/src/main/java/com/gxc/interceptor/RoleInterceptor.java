package com.gxc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限控制
 * @author 宫新程
 */
public class RoleInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL，放行登录和验证码
		String requestURL = request.getRequestURL().toString();
		if(requestURL.indexOf("/login") >= 0 || requestURL.indexOf("/generate")>=0 || requestURL.indexOf("/user/exitSystem")>=0){
			return true;
		}
		//从session中获取loginRole
		Integer role = (Integer)request.getSession().getAttribute("loginRole");
		if(role == null){
			response.sendRedirect("/user/exitSystem.html");
			return false;
		}
		
		//路径判断->权限控制
		switch (role) {
			case 1://超级管理员
					if(requestURL.indexOf("/stu/")>=0 || requestURL.indexOf("/drom/")>=0){
						response.sendRedirect("/page/errorRole.html");
						return false;
					}
				break;
			case 2://宿管员
					if(requestURL.indexOf("/stu/")>=0 || requestURL.indexOf("/admin/")>=0){
						response.sendRedirect("/page/errorRole.html");
						return false;
					}
				break;
			case 3://学生
					if(requestURL.indexOf("/drom/")>=0 || requestURL.indexOf("/admin/")>=0){
						response.sendRedirect("/page/errorRole.html");
						return false;
					}
				break;
			default:
				response.sendRedirect("/user/exitSystem.html");
				return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
