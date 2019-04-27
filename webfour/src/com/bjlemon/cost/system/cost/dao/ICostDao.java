package com.bjlemon.cost.system.cost.dao;

import java.util.List;

import com.bjlemon.pojo.Cost;

public interface ICostDao {

	Integer insertCost(Cost cost) throws Exception;

	List<Cost> queryCo(Cost cost) throws Exception;

	Integer update1(String[] cost) throws Exception;

	Integer update(Cost cost) throws Exception;

}
