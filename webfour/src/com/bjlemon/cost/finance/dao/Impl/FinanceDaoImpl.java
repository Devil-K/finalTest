package com.bjlemon.cost.finance.dao.Impl;

import java.util.List;

import com.bjlemon.cost.finance.dao.IFianceDao;
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
import com.bjlemon.utils.C3p0Util;

public class FinanceDaoImpl implements IFianceDao {

	@Override
	public List<Salary> queryFinList(Salary sal) throws Exception {
		String sql =" select * from t_salary_record re ,t_user u where u.userId = re.userId  ";
		List<Salary> sallist= C3p0Util.queryList(sql, Salary.class);
		return sallist;
	}

	@Override
	public List<Expense> queryAuditFinanceAllList(Expense exp) throws Exception {
		// TODO Auto-generated method stub
		String sql =" select * from t_expense ex ,t_user u where ex.userId =u.userId and expenseMark !=-1 ";
		List<Expense> list=C3p0Util.queryList(sql, Expense.class);
		return list;
	}

	@Override
	public List<Expense> queryExpenseDe1(Integer expenId) throws Exception {
		String sql=" select * from t_expense where expenseId = ? ";
		List<Expense>	list=C3p0Util.queryList(sql, Expense.class,expenId);
		System.out.println("报销单详情上部信息"+list);
			return list;
	}

	@Override
	public List<ExpenseDetail> queryExpenseDe2(Integer expenId) throws Exception {
		String sql=" select * from  t_expense_detail ed,t_cost ex where ex.costId =ed.costId and ed.expenseId=? ";
		List<ExpenseDetail>	list=C3p0Util.queryList(sql, ExpenseDetail.class,expenId);
		System.out.println(sql);
		System.out.println("报销单详情信息 中部"+list);
			return list;
	}

	@Override
	public List<AuditRecend> queryExpenseDe3(Integer expenId) throws Exception {
		String sql=" select * from  t_audit_recnd re, t_user u where re.userId =u.userId  and re.expenseId=? ";
		List<AuditRecend>	list=C3p0Util.queryList(sql, AuditRecend.class,expenId);
		System.out.println(sql);
		System.out.println("报销单详情信息 下部"+list);
		return list;
	}

	@Override
	public Integer insertAuditRe(AuditRecend ar) throws Exception {
		String sta=ar.getAuditState();
		if("-3".equals(sta)){
			sta="财务审核不通过";
			
		}else{
			sta="财务审核通过";
		}
		String sql=" insert into t_audit_recnd (expenseId ,userId ,auditState ,auditSugg ,auditDate ) values(?,?,?,?, NOW() )";
		int row=C3p0Util.update(sql, ar.getExpenseId(),ar.getUserId(),sta,ar.getAuditSugg());
		return row;
	}

	@Override
	public List<User> queryAddSalary(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql=" select * from t_user";
	List<User>	list=C3p0Util.queryList(sql, User.class);
		return list;
	}

	@Override
	public Integer insertAddSalary(Salary sa) throws Exception {
		String sql=" insert into t_salary_record( userId ,salaryMonth , salaryDate ,salaryBasic ,salaryComm  ) values( ?,?,NOW() , ? ,?) ";
		System.out.println("发放工资的语句"+sql);
		int a=C3p0Util.update(sql, sa.getUserId(),sa.getSalaryMonth(),sa.getSalaryBasic(),sa.getSalaryComm());
		return a;
	}

}
