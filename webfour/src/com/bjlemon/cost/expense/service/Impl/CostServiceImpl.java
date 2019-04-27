package com.bjlemon.cost.expense.service.Impl;

import java.util.List;

import com.bjlemon.cost.expense.dao.ICostDao;
import com.bjlemon.cost.expense.dao.Impl.CostDaoImpl;
import com.bjlemon.cost.expense.service.ICostService;
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;

public class CostServiceImpl implements ICostService {

	private ICostDao costdao=new CostDaoImpl();
	@Override
	public List<Cost> queryCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryCos(cost);
	}
	@Override
	public boolean addCost(Expense expenseParm) throws Exception {
		int row = costdao.insertInto(expenseParm); 
		return row!=0?true:false;
	}
	@Override
	public List<Expense> showAudit(Expense expenseParm) throws Exception {
		// TODO Auto-generated method stub
		List<Expense> list=costdao.queryAudit(expenseParm);
		for(Expense e:list){
			if(e.getExpenseState().equals("0")){
				e.setExpenseState("<button class='btn btn-info'>待经理审核</button>");
			}if(e.getExpenseState().equals("1")){
				e.setExpenseState("<button class='btn btn-info'>经理审核通过</button>");
			}if(e.getExpenseState().equals("2")){
				e.setExpenseState("<button class='btn btn-info'>经理审核不通过</button>");
			}
			
		}
		return list;
	}
	@Override
	public List<Expense> queryExpense(Expense expense) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryDetil( expense);
	}
	@Override
	public List<Expense> queryExpenseD1(Integer exp) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryExpenseDe1(exp);
	}
	@Override
	public List<Expense> queryMyselfExpense(Integer listId) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryMelf(listId);
	}
	@Override
	public List<ExpenseDetail> queryExpenseD2(Integer expenId) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryExpenseDe2(expenId);
	}
	@Override
	public List<AuditRecend> queryExpenseD3(Integer expenId) throws Exception {
		// TODO Auto-generated method stub
		return costdao.queryExpenseDe3(expenId);
	}
	@Override
	public boolean insertIntoAudit(AuditRecend audit) throws Exception {
		int co=costdao.insertIntoAudit(audit);
	
		
		return co==1?true:false;
	}

}
