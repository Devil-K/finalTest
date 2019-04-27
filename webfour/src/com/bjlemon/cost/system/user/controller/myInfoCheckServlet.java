package com.bjlemon.cost.system.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/system/queryMyInfo")
public class myInfoCheckServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserService service=new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Object myInfo=	req.getSession().getAttribute("userInfo");
	
	/*HttpSession session= request.getSession();			//问题很大这个语句/////////////////////////////////////
	session.setAttribute("userInfo", myInfo);*/
	
	System.out.println("个人信息"+myInfo);
	req.setAttribute("myInfo", myInfo);
	req.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=RequestBeanUtils.requestToBean(req, User.class);
		try {
			boolean change=service.changeMyInfo(user);
			if(change){
				req.setAttribute("tip", "修改成功");
			}
			req.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
