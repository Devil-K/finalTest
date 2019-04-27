package com.bjlemon.cost.system.user.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.User;
import com.bjlemon.utils.C3p0Util;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/deleteUsers")
public class deleteUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserService userservice=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	User user=RequestBeanUtils.requestToBean(req, User.class);
////		userservice.delUsers();
//		String a=user.getCk();
//		Integer b=user.getUserId();
//		System.out.println(b);
//		System.out.println("String a=user.getCk();String a=user.getCk();String a=user.getCk();"+a);
		 String[] ids=req.getParameterValues("ids");
		 System.out.println(ids);
		 System.out.println(Arrays.toString(ids));
		try {
			boolean del= userservice.delUser( ids );
			if(del){
				req.setAttribute("tip", "É¾³ý³É¹¦");	
			}
			req.getRequestDispatcher("/system/checkUser").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
