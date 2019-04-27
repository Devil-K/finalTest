package com.bjlemon.cost.expense.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.expense.service.ICostService;
import com.bjlemon.cost.expense.service.Impl.CostServiceImpl;
import com.bjlemon.pojo.Expense;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/expense/queryAllExpense")
public class queryAllExpenseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private ICostService service=new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Expense exp=	RequestBeanUtils.requestToBean(req, Expense.class);
	try {
	List<Expense> list=	service.showAudit(exp);
	req.setAttribute("list", list);
	req.getRequestDispatcher("/view/expense/expense/expense_list.jsp").forward(req, resp);
	
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
