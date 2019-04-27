package com.bjlemon.cost.system.cost.serviceImpl;

import java.util.List;

import com.bjlemon.cost.system.cost.dao.ICostDao;
import com.bjlemon.cost.system.cost.dao.impl.CostDaoImpl;
import com.bjlemon.cost.system.cost.service.ICostService;
import com.bjlemon.pojo.Cost;

public class CostServiceImpl implements  ICostService {
private ICostDao costdao=new CostDaoImpl();
	@Override
	public boolean addCost(Cost cost) throws Exception {
		int row =costdao.insertCost(cost);
		
		return row==0?false:true;
	}
	@Override
	public List<Cost> queryCost(Cost cost) throws Exception {
		List<Cost> row=costdao.queryCo(cost);		
		return row;
	}
	
	@Override
	public boolean deleteCost(String[] cost) throws Exception {
		int row=costdao.update1(cost);
		return row!=0?true:false;
	}
	@Override
	public boolean changeCost(Cost cost) throws Exception {
	int row=costdao.update(cost);
		return row!=0?true:false;
	}

}
