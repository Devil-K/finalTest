package com.bjlemon.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class session_doFilter implements  Filter {


	@Override
	public void destroy() {
	 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断当前请求的用户session 是否存在

		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse) response;
		
		Object currentUser= req.getSession().getAttribute("userInfo");
 
		
		if(currentUser!=null) {
			//该用户登录过
			chain.doFilter(request, response);
		}else if( req.getRequestURI().contains("/system/doLogin")) {
			//登录放行
			chain.doFilter(request, response);
		}else if(req.getRequestURI().contains("/resource") ){
			// 静态资源放行
			chain.doFilter(request, response);
		}else if(req.getRequestURI().contains("login.jsp")){
			chain.doFilter(request, response);
		} 
		else{
			//没有登录
			//req.getRequestDispatcher("/view/login.jsp").forward(request, response);//转发
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");//重定向
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
