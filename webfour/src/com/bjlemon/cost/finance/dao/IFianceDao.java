package com.bjlemon.cost.finance.dao;

import java.util.List;

import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

public interface IFianceDao {

	List<Salary> queryFinList(Salary sal) throws Exception;

	List<Expense> queryAuditFinanceAllList(Expense exp)throws Exception;

	List<Expense> queryExpenseDe1(Integer expenId)throws Exception;

	List<ExpenseDetail> queryExpenseDe2(Integer expenId)throws Exception;

	List<AuditRecend> queryExpenseDe3(Integer expenId)throws Exception;

	Integer insertAuditRe(AuditRecend auditRecend )throws Exception;

	List<User> queryAddSalary(User user)throws Exception;

	Integer insertAddSalary(Salary salary)throws Exception;

}
