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
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

import net.sf.json.JSONObject;

@WebServlet("/finance/salaryQuery")
public class ajaxQuerySalaryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IFinanceService service=new FinanceServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User use=RequestBeanUtils.requestToBean(req, User.class);
		try {
			List<User> user=service.queryAddSalary(use);
			User u=user.get(0);
			JSONObject obj=new JSONObject();
			
			obj.put("userSalary", u.getUserSalary());
			
			resp.getWriter().println(obj);
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
