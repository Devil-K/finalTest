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
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/expense/myselfExpense")
public class queryMselfListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ICostService service=new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	Expense exp=	RequestBeanUtils.requestToBean(req, Expense.class);
	
	try {
	User user=	(User) req.getSession().getAttribute("userInfo");
	Integer listId=user.getUserId();
	List<Expense> list=	service.queryMyselfExpense(listId);
	req.setAttribute("list", list);
	req.getRequestDispatcher("/view/expense/expense/expense_mylist.jsp").forward(req, resp);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}}