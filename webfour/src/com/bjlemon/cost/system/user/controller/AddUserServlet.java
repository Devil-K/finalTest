package com.bjlemon.cost.system.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/addUser")
public class AddUserServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService= new UserServiceImpl();//引入服务
	
	@Override()
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得前端参数
		User user=RequestBeanUtils.requestToBean(req, User.class);//接受请求参数的工具类，前端请求参数封装指定类型对象
		System.out.println(user);
		//调用业务方法
		try {
			userService.add(user);
			req.setAttribute("tip", "数据保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tip", "数据保存失败");
		}
		req.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(req, resp);//跳转

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	
}
