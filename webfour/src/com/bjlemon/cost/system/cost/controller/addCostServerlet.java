package com.bjlemon.cost.system.cost.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjlemon.cost.system.cost.service.ICostService;
import com.bjlemon.cost.system.cost.serviceImpl.CostServiceImpl;
import com.bjlemon.pojo.Cost;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/system/addCost")
public class addCostServerlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICostService costservice=new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cost cost=RequestBeanUtils.requestToBean(req, Cost.class);
	try {
		boolean cos=costservice.addCost(cost);
		if(cos){
			req.setAttribute("tip", "Ìí¼Ó³É¹¦");
			req.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(req, resp);
		}
		
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
