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
	private IUserService userService= new UserServiceImpl();//�������
	
	@Override()
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ǰ�˲���
		User user=RequestBeanUtils.requestToBean(req, User.class);//������������Ĺ����࣬ǰ�����������װָ�����Ͷ���
		System.out.println(user);
		//����ҵ�񷽷�
		try {
			userService.add(user);
			req.setAttribute("tip", "���ݱ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("tip", "���ݱ���ʧ��");
		}
		req.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(req, resp);//��ת

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	
}
