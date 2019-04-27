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
import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/doLogin")
public class UserLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	static IUserService userservice= new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User use=RequestBeanUtils.requestToBean(req, User.class);
		 try {
			User service=userservice.login(use.getUserAccount(),use.getUserPwd());
			if(service==null){
				System.out.println("��½ʧ��");
				req.setAttribute("tip", "error���˺Ż��������");
				req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			}else{
				System.out.println("��½�ɹ�");
				req.getSession().setAttribute("userInfo", service);//////////////////////////
				//resp.sendRedirect("");
				List<Menus> menu=	userservice.findMenus(service.getRoleId());
				req.setAttribute("Menus", menu);
				req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
				System.out.println(" ��ȡ��ɫ��ID "+service.getRoleId());
				System.out.println(" ��ȡ��ɫ�Ĳ˵� "+menu);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		// List<Menus>  menus=  userService.findMenus( loginUser.getRoleId()  );  
		
			//C3p0Util.queryOne(sql, User.class);
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
