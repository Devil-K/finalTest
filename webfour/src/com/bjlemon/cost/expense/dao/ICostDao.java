package com.bjlemon.cost.expense.dao;

import java.util.List;

import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;

public interface ICostDao {

	List<Cost> queryCos(Cost cost) throws Exception;

	Integer insertInto(Expense expenseParm) throws Exception;

	List<Expense> queryAudit(Expense expenseParm) throws Exception;

	List<Expense> queryDetil(Expense expense) throws Exception;

	List<Expense> queryExpenseDe1(Integer exp) throws Exception;

	List<Expense> queryMelf(Integer listId) throws Exception;

	List<ExpenseDetail> queryExpenseDe2(Integer expenId) throws Exception;

	List<AuditRecend> queryExpenseDe3(Integer expenId) throws Exception;

	Integer insertIntoAudit(AuditRecend audit) throws Exception;

}
