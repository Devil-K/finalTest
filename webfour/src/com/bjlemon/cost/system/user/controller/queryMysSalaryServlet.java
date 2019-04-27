package com.bjlemon.cost.system.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.cost.system.user.service.impl.UserServiceImpl;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/queryMySalary")
public class queryMysSalaryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
private IUserService service=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Salary salary=RequestBeanUtils.requestToBean(req, Salary.class);
		//String salaryMonth=req.getParameter("salaryMonth");
		User user=(User) req.getSession().getAttribute("userInfo");		
		System.out.println("huo+++"+user.getUserId());
		try {
			List<Salary> list=service.querySalary(user);
			req.setAttribute("salaryList", list);
			Salary edlist=list.get(0);
			System.out.println("工资的参数列表"+edlist);
			req.getRequestDispatcher("/view/system/user/salarypayment_mylist.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("查询工资的post提交    ");
	doGet(req, resp);
	
	}
}
