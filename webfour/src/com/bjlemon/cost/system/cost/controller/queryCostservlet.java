package com.bjlemon.cost.system.cost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.cost.service.ICostService;
import com.bjlemon.cost.system.cost.serviceImpl.CostServiceImpl;
import com.bjlemon.pojo.Cost;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/queryCosts")
public class queryCostservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICostService costservice=new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cost cost=RequestBeanUtils.requestToBean(req, Cost.class);
	try {
		List<Cost> getrow=costservice.queryCost(cost);
		req.setAttribute("costs", getrow);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		req.getRequestDispatcher("/view/system/cost/cost_list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
