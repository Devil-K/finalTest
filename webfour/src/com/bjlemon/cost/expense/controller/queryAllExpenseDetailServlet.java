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

@WebServlet("/expense/showExpenseDetail")
public class queryAllExpenseDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICostService service =new CostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Expense exp=RequestBeanUtils.requestToBean(req, Expense.class);
		Integer ExpenId=exp.getExpenseId();//��Ӧ�ı��������
		try {
			//������Ϣ
			List<Expense> list1=service.queryExpenseD1(ExpenId);
			Expense edlist=list1.get(0);
			req.setAttribute("expense", edlist);
			System.out.println("�����������ϸ�ϲ�"+edlist);
			//����������
			List<ExpenseDetail> list2=service.queryExpenseD2(ExpenId);
			req.setAttribute("detailList", list2);
			System.out.println("�����������ϸ�в���ϸ"+list2);
			//�²�����
			List<AuditRecend> list3=service.queryExpenseD3(ExpenId);
			req.setAttribute("recordList", list3);
			req.getRequestDispatcher("/view/expense/expense/expense_show.jsp").forward(req, resp);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
