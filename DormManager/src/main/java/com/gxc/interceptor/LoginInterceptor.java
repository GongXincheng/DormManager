package com.gxc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 验证用户是否登录的过滤器
 * @author 宫新程
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL，放行登录和验证码
		String requestURL = request.getRequestURL().toString();
		if(requestURL.indexOf("/login") >= 0 || requestURL.indexOf("/generate")>=0){
			return true;
		}
		//从Session中获取登录的用户信息
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute("loginUser");
		
		//如果没有登录
		if(loginUser==null){
			response.sendRedirect("http://localhost:8080/page/login.html");
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
