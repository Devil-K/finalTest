package com.bjlemon.cost.system.user.controller;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;
import com.sun.org.apache.regexp.internal.recompile;

import net.sf.json.JSONObject;

//��֤����
@WebServlet("/system/checkUser")
public class CheckUserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private IUserService uservice =new UserServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");	
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		User user= RequestBeanUtils.requestToBean(req, User.class);//��ȡģ��
		String userAccount=user.getUserAccount();//ģ���е�һ��ֵ
		JSONObject rsObject=new JSONObject();//����JSON
		try {
			boolean exists=uservice.check(userAccount);
			if(exists){				
				rsObject.put("state", true);
				rsObject.put("tip", "error �û����Ѿ�����");
			}else{
				rsObject.put("state", false);
				rsObject.put("tip", "yes,����ʹ��");
			}
			resp.getWriter().print(rsObject);
			PrintStream ps=new PrintStream(resp.getOutputStream());
			ps.print(rsObject);
			ps.flush();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setCharacterEncoding("utf-8");	
	resp.setHeader("Content-type", "text/html;charset=UTF-8");
	doGet(req,resp);
	}
}
