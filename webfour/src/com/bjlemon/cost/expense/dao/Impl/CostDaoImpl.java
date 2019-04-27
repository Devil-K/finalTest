package com.bjlemon.cost.expense.dao.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bjlemon.cost.expense.dao.ICostDao;
import com.bjlemon.pojo.AuditRecend;
import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;
import com.bjlemon.pojo.ExpenseDetail;
import com.bjlemon.utils.C3p0Util;

public class CostDaoImpl implements ICostDao {

	@Override
	public List<Cost> queryCos(Cost cost) throws Exception {
		String sql=" select * from t_cost where 1 = 1 and costmark != -1 ";
		System.out.println("费用明细的sql语句"+sql);
		List<Cost> cosList=C3p0Util.queryList(sql, Cost.class);
		System.out.println("费用明细下拉列表"+cosList);
		return cosList;
	}

	@Override
	public Integer insertInto(Expense exp) throws Exception {
		Connection conn =C3p0Util.getConn();
		conn.setAutoCommit(false);
		//SQL执行器
		 QueryRunner runner= new QueryRunner();
		 int row=0;
		 try {
			String sql=" insert into t_expense( userId ,expenseName ,expenseDesc ,expenseToltel ,expenseDate ,expenseState ,expenseMark)"+
		 " values(?,?,?,?,now(),'1',0)";
			row=runner.update(conn,sql,exp.getUserId(),exp.getExpenseName(),exp.getExpenseDesc(),exp.getExpenseToltel());		
			//查询自增长的ID
			String sqlid=" select last_insert_id()";
		Object expenseId=runner.query(conn,sqlid,new ScalarHandler<>());	
		//插入明细信息
		String sqlDetail=" insert into t_expense_detail(expenseId , costId , detailDesc ,detailMoney ,detailMark)"+
		" values(?,?,?,?,0 )";
		for(int i=0;i<exp.getCostIds().length;i++){
			row+=runner.update(conn,sqlDetail,expenseId,exp.getCostIds()[i],exp.getDetailDescs()[i],exp.getDetailMoneys()[i]);
		}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			row=-1;
		}
		return row;

		
		
	}

	@Override
	public List<Expense> queryAudit(Expense exp) throws Exception {
		String sql=" select * from t_expense  e , t_user u where  e.userId = u.userId  ";
		
		ArrayList<Object> parm=new ArrayList<>();
		if(exp.getExpenseId()!=null&& exp.getExpenseId()!=0){
			sql+=" and e.expenseId = ? " ;
			parm.add(exp.getExpenseId());
			
		}if(exp.getUserName()!=null&&  !"".equals(exp.getUserName())){
			sql+=" and u.userName = ? " ;
			parm.add(exp.getUserName());
			
		}if(exp.getStartDate()!=null&& !"".equals(exp.getStartDate()) ){
			sql+=" and e.expenseDate > ? " ;
			parm.add(exp.getStartDate());
		}if(exp.getEndDate()!=null&& !"".equals(exp.getEndDate())){
			sql+=" and e.expenseDate < ? " ;
			parm.add(exp.getExpenseId());
		}if(exp.getExpenseName()!=null&& !"".equals(exp.getExpenseName()) ){
			sql+=" and e.expenseName = ? " ;
			parm.add(exp.getExpenseName());
		}if(exp.getExpenseState()!=null&& !"".equals(exp.getExpenseState())){
			sql+=" and e.expenseState = ? " ;
			parm.add(exp.getExpenseState());
		}
		System.out.println("tiaojian chaxun  de yuju "+sql);
		List<Expense> list=C3p0Util.queryList(sql, Expense.class ,parm.toArray());
		
	System.out.println("jingli审批列表"+list);
		return list;
	}

	@Override
	public List<Expense> queryDetil(Expense expense) throws Exception {
		String sql=" SELECT * FROM t_expense e , t_expense_detail ed WHERE  e.expenseId = ed.expenseId   ";
		List<Expense> listDetil=C3p0Util.queryList(sql, Expense.class);
		System.out.println("查询经理审批详细表特多"+listDetil);
		return null;
	}

	@Override//查询报销单详情     		上部
	public List<Expense> queryExpenseDe1(Integer exp) throws Exception {
		String sql=" select * from t_expense where expenseId = ? ";
	List<Expense>	list=C3p0Util.queryList(sql, Expense.class,exp);
	System.out.println("报销单详情上部信息"+list);
		return list;
	}

	@Override//我的报销信息
	public List<Expense> queryMelf(Integer listId) throws Exception {
		String sql=" select * from t_expense e , t_user u where e.userId =u.userId and  u.userId = ? ";
		List<Expense>	list=C3p0Util.queryList(sql, Expense.class,listId);
		return list;
	}

	@Override   //报销单 中部 的报销单详情
	public List<ExpenseDetail> queryExpenseDe2(Integer expenId) throws Exception {
		String sql=" select * from  t_expense_detail ed,t_cost ex where ex.costId =ed.costId and ed.expenseId=? ";
		List<ExpenseDetail>	list=C3p0Util.queryList(sql, ExpenseDetail.class,expenId);
		System.out.println(sql);
		System.out.println("报销单详情信息 中部"+list);
			return list;
	}

	@Override//报销单详情 下部分
	public List<AuditRecend> queryExpenseDe3(Integer expenId) throws Exception {
		String sql=" select * from  t_audit_recnd re, t_user u where re.userId =u.userId  and re.expenseId=? ";
		List<AuditRecend>	list=C3p0Util.queryList(sql, AuditRecend.class,expenId);
		System.out.println(sql);
		System.out.println("报销单详情信息 下部"+list);
		return list;
	}

	@Override //经理在审核
	public Integer insertIntoAudit(AuditRecend au) throws Exception {
		String auditStat;
//		auditStat="-1".equals(au.getAuditState())?"经理审核不通过":"审核通过";
		if("-1".equals(au.getAuditState())){
			auditStat="经理审核不通过";
			String sq=" update t_expense e ,t_audit_recnd ar set e.expenseState = ? where e.expenseId =ar.expenseId";
			String sq1="update t_expense e ,t_audit_recnd ar set  e.expenseMark = -1 where e.expenseId =ar.expenseId";
			C3p0Util.update(sq, auditStat);
			C3p0Util.update(sq1);
		}else{
			auditStat="经理审核通过";	
			String sq=" update t_expense e ,t_audit_recnd ar set e.expenseState = ? where e.expenseId =ar.expenseId";
			C3p0Util.update(sq, auditStat);
			
		}
		
		String sql=" insert into t_audit_recnd(expenseId ,userId ,auditState ,auditSugg ,auditDate) values(?,?,?,?,NOW() )";
		System.out.println("审核提交"+sql);
		int row=C3p0Util.update(sql, au.getExpenseId(),au.getUserId(),auditStat,au.getAuditSugg());
		
		return row;
	}

}
