package com.bjlemon.cost.system.cost.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjlemon.cost.system.cost.dao.ICostDao;
import com.bjlemon.pojo.Cost;
import com.bjlemon.utils.C3p0Util;

public class CostDaoImpl implements ICostDao {
	@Override
	public Integer insertCost(Cost cost) throws Exception {
		String sql="insert into t_cost(costName,costDesc,costMark) values(?,?,?)";
		int ro=C3p0Util.update(sql, cost.getCostName(),cost.getCostDesc(),0);
		return ro;
		}

	
	@Override
	public List<Cost> queryCo(Cost cost) throws Exception {
		StringBuffer sql=new StringBuffer("select * from t_cost where 1=1 and costMark !=-1 ");
		ArrayList<Object> values=new ArrayList<>();
		if(cost.getCostId()!=0 && cost.getCostId()!=null){
			sql.append(" and costId=? ");
			values.add(cost.getCostId());
		}
		if(cost.getCostName()!=null&&!"".equals(cost.getCostName())){
			sql.append(" and costName=? ");
			values.add(cost.getCostName());
		}
		
		System.out.println(sql);
//		int u=C3p0Util.update(sql);
		if(cost.getCostId()!=0 && cost.getCostId()!=null&&cost.getCostName()!=null&&!"".equals(cost.getCostName())){
			List<Cost> costlist=C3p0Util.queryList(sql.toString(),Cost.class);
			return costlist;
		}else{
			
			List<Cost> costlist=C3p0Util.queryList(sql.toString(),Cost.class,values.toArray());	
			System.out.println(costlist);
			return costlist;
		}
		
//		System.out.println(u);
		
	}


	@Override
	public Integer update1(String[] cost) throws Exception {
		String sql="update t_cost set costMark = -1 where costId=? ";
		int up=1;
		for(int i=0;i<cost.length;i++){
			String cos=cost[i];
			up+=C3p0Util.update(sql, cos);
		}
		return up;
	}


	@Override
	public Integer update(Cost cost) throws Exception {
		String sql="update t_cost set costName=? ,costDesc=? ,costMark=? where costId=?";
		int roo=	C3p0Util.update(sql, cost.getCostName(),cost.getCostDesc(),0,cost.getCostId());
		return roo;
	}

}
