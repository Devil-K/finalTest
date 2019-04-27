package com.bjlemon.cost.finance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.bjlemon.cost.finance.service.IFinanceService;
import com.bjlemon.cost.finance.service.Impl.FinanceServiceImpl;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/finance/payFinance")//薪资发放
public class addPaySalaryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IFinanceService service=new FinanceServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=RequestBeanUtils.requestToBean(req, User.class);
		try {
			List<User> list=service.queryAddSalary(user);
			
			req.setAttribute("userList", list);
			req.setAttribute("userSalary", list);
			System.out.println("员工职位对应薪水的列表"+list);
			req.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Salary salary=RequestBeanUtils.requestToBean(req, Salary.class,"yyyy-MM-dd");
//		salary.setSalaryMonth(salary.getSalaryMonth());
		try {
			boolean issuccess=service.insertPaySalary(salary);
			if(issuccess){
				req.setAttribute("tip", "工资发放成功");
			}
			req.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
