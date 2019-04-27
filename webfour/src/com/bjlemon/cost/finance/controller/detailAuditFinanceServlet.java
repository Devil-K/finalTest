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
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.my.web.servlet.RequestBeanUtils;

@WebServlet("/finance/financeAudit") //财务审核界面
public class detailAuditFinanceServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IFinanceService service=new FinanceServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Expense exp=RequestBeanUtils.requestToBean(req, Expense.class);
		Integer ExpenId =exp.getExpenseId();
		List<Expense> list1;
		try {
			list1 = service.queryExpenseD1(ExpenId);
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
			
			
			req.getRequestDispatcher("/view/finance/financAaudit/financeaudit_audit.jsp").forward(req, resp);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuditRecend auditRecend=RequestBeanUtils.requestToBean(req, AuditRecend.class);
		try {
			boolean ar=service.insertAuditRecend(auditRecend);
			if(ar){
				req.setAttribute("tip", "财务审核提交成功");
				req.getRequestDispatcher("/view/finance/financAaudit/financeaudit_audit.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
