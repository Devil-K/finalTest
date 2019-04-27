package com.bjlemon.cost.finance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.finance.service.IFinanceService;
import com.bjlemon.cost.finance.service.Impl.FinanceServiceImpl;
import com.bjlemon.pojo.Salary;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/finance/queryFinance")//所有已经发放薪资查询列表
public class queryListAllSalaryServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private IFinanceService service =new FinanceServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Salary sal=	RequestBeanUtils.requestToBean(req, Salary.class);
	try {
		List<Salary> list=service.queryAllsal(sal);
		req.setAttribute("salaryList", list);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		req.getRequestDispatcher("/view/finance/salary/salarypayment_list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
}
