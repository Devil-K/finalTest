package com.bjlemon.cost.finance.service.Impl;

import java.util.List;

import com.bjlemon.cost.finance.dao.IFianceDao;
import com.bjlemon.cost.finance.dao.Impl.FinanceDaoImpl;
import com.bjlemon.cost.finance.service.IFinanceService;
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

public class FinanceServiceImpl implements IFinanceService {

	private IFianceDao findao=new FinanceDaoImpl();
	@Override
	public List<Salary> queryAllsal(Salary sal) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryFinList(sal);
	}
	@Override
	public List<Expense> auditFinanceAllList(Expense exp) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryAuditFinanceAllList(exp);
	}
	@Override
	public List<Expense> queryExpenseD1(Integer expenId) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryExpenseDe1(expenId);
	}
	@Override
	public List<ExpenseDetail> queryExpenseD2(Integer expenId) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryExpenseDe2(expenId);
	}
	@Override
	public List<AuditRecend> queryExpenseD3(Integer expenId) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryExpenseDe3(expenId);
	}
	@Override
	public boolean insertAuditRecend(AuditRecend auditRecend) throws Exception {
		int row=findao.insertAuditRe(auditRecend);
		return row==1?true:false;
	}
	@Override
	public List<User> queryAddSalary(User user) throws Exception {
		// TODO Auto-generated method stub
		return findao.queryAddSalary(user);
	}
	@Override
	public boolean insertPaySalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		int reo=findao.insertAddSalary(salary);
		return reo==1?true:false;
	}

}
