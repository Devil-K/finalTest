package com.bjlemon.cost.finance.service;

import java.util.List;

import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

public interface IFinanceService {

	List<Salary> queryAllsal(Salary sal) throws Exception;

	List<Expense> auditFinanceAllList(Expense exp) throws Exception;

	List<Expense> queryExpenseD1(Integer expenId)throws Exception;

	List<ExpenseDetail> queryExpenseD2(Integer expenId)throws Exception;

	List<AuditRecend> queryExpenseD3(Integer expenId)throws Exception;

	boolean insertAuditRecend(AuditRecend auditRecend) throws Exception;

	List<User> queryAddSalary(User user)throws Exception;

	boolean insertPaySalary(Salary salary)throws Exception;

}
