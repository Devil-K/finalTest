package com.bjlemon.cost.expense.service;

import java.util.List;

import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;

public interface ICostService {

	List<Cost> queryCost(Cost cost) throws Exception;

	boolean addCost(Expense expenseParm) throws Exception;

	List<Expense> showAudit(Expense expenseParm) throws Exception;

	List<Expense> queryExpense(Expense expense) throws Exception;
	List<Expense> queryMyselfExpense(Integer listId) throws Exception;
	List<Expense> queryExpenseD1(Integer expenId) throws Exception;
	List<ExpenseDetail> queryExpenseD2(Integer expenId)throws Exception;
	List<AuditRecend> queryExpenseD3(Integer expenId) throws Exception;

	boolean insertIntoAudit(AuditRecend audit) throws Exception;



}
