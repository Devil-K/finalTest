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
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.utils.C3p0Util;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/expense/addExpense")
public class addExpenseServlet extends HttpServlet{
	private ICostService costservice=new CostServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cost cost=new Cost();
//		Cost cost=RequestBeanUtils.requestToBean(req, Cost.class);
		try {
		List<Cost> costList=	costservice.queryCost(cost);
		System.out.println("fe费用明细按钮菜单"+costList);
		req.setAttribute("costs", costList);
		req.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(req, resp);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	@Override//提交表单
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Expense expenseParm=RequestBeanUtils.requestToBean(req, Expense.class);
	try {
		boolean isseccess=costservice.addCost(expenseParm);
		if(isseccess){
			req.setAttribute("tip", "提交成功");
		}else{
			req.setAttribute("tip","失败");
		}
		req.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(req, resp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
