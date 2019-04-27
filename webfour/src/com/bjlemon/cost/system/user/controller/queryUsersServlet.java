package com.bjlemon.cost.system.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.User;
import com.bjlemon.utils.C3p0Util;
import com.my.web.servlet.RequestBeanUtils;
@WebServlet("/system/queryUsers")
public class queryUsersServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private IUserService userservice= new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User user=RequestBeanUtils.requestToBean(req, User.class);

	try {
		List<User> u1=userservice.checkUser(user);
		System.out.println("返回对象u1"+u1);
		req.setAttribute("users", u1);
	
	} catch (Exception e) {
		System.out.println("出现了异常");
		
		e.printStackTrace();
	}
	req.getRequestDispatcher("/view/system/user/userinfo_list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
