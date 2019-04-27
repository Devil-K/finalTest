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
		//�жϵ�ǰ������û�session �Ƿ����

		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse) response;
		
		Object currentUser= req.getSession().getAttribute("userInfo");
 
		
		if(currentUser!=null) {
			//���û���¼��
			chain.doFilter(request, response);
		}else if( req.getRequestURI().contains("/system/doLogin")) {
			//��¼����
			chain.doFilter(request, response);
		}else if(req.getRequestURI().contains("/resource") ){
			// ��̬��Դ����
			chain.doFilter(request, response);
		}else if(req.getRequestURI().contains("login.jsp")){
			chain.doFilter(request, response);
		} 
		else{
			//û�е�¼
			//req.getRequestDispatcher("/view/login.jsp").forward(request, response);//ת��
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");//�ض���
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
