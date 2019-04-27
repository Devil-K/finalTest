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

@WebServlet("/system/updateCost")
public class updateCostServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICostService service=new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cost cost=RequestBeanUtils.requestToBean(req, Cost.class);
		try {
		List<Cost> colist=	service.queryCost(cost);
		Cost edlist=colist.get(0);
		req.setAttribute("cost", edlist);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cost cost=RequestBeanUtils.requestToBean(req, Cost.class);
		try {
			boolean cos=service.changeCost(cost);
			if(cos){
				req.setAttribute("tip", "ÐÞ¸Ä³É¹¦");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(req, resp);
		
	}

}
