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
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/expense/manageAduitExpense")
public class DetilAndAuditExpenseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICostService service =new CostServiceImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Expense exp=RequestBeanUtils.requestToBean(req, Expense.class);
	Integer ExpenId=exp.getExpenseId();//对应的报销单编号
	try {
		//基本信息
		List<Expense> list1=service.queryExpenseD1(ExpenId);
		Expense edlist=list1.get(0);
		req.setAttribute("expense", edlist);
		System.out.println("控制器里的详细上部"+edlist);
		//报销单详情
		List<ExpenseDetail> list2=service.queryExpenseD2(ExpenId);
		req.setAttribute("detailList", list2);
		System.out.println("控制器里的详细中部明细"+list2);
		//下部详情
		List<AuditRecend> list3=service.queryExpenseD3(ExpenId);
		req.setAttribute("recordList", list3);
		req.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(req, resp);	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("获取对应的报销单号"+exp.getExpenseId());
	
	
	
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	Expense exp=RequestBeanUtils.requestToBean(req, Expense.class);
//	Integer ExpenId=exp.getExpenseId();//对应的报销单编号
	
	AuditRecend audit=RequestBeanUtils.requestToBean(req, AuditRecend.class);
	try {
		boolean issuccess=service.insertIntoAudit(audit);
		
		
		if(issuccess){
			req.setAttribute("tip", "审核提交成功");
		}else{
			req.setAttribute("tip", "审核提交失败");
		}
		req.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(req, resp);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
