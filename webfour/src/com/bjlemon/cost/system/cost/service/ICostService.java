package com.bjlemon.cost.system.cost.service;

import java.util.List;

import com.bjlemon.pojo.Cost;
import com.bjlemon.pojo.Expense;

public interface ICostService {

	boolean addCost(Cost cost)throws Exception;

	List<Cost> queryCost(Cost cost)throws Exception;

//	boolean deleteCost(String cost)throws Exception;

	boolean deleteCost(String[] cost)throws Exception;

	boolean changeCost(Cost cost) throws Exception;

//	List<Expense> queryExpense(Expense expense) throws Exception;


}
