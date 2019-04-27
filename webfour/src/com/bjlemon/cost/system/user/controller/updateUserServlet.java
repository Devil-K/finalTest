package com.bjlemon.cost.system.user.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/system/updateUser")
public class updateUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
private IUserService userservice= new 	UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = RequestBeanUtils.requestToBean(req, User.class);
		
		try {
			List<User> list = userservice.checkUser(user);
			User edlist=list.get(0);
			req.setAttribute("user", edlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User upUser = RequestBeanUtils.requestToBean(req, User.class);
		try {
//			List<User> list2 = userservice.updateUser(upUser);
			boolean isseccess= userservice.updateUser1(upUser);
			if(isseccess){
				req.setAttribute("tip", "修改成功");
				
			}else{
				req.setAttribute("tip", "修改失败");
				
			}
		} catch (Exception e) {
			req.setAttribute("tip", "修改失败");
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(req, resp);
	}

}
