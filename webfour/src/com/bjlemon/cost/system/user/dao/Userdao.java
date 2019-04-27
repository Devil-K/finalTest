package com.bjlemon.cost.system.user.dao;

import java.util.List;

import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

//用户持久层接口
public interface Userdao {

	Integer insert(User user) throws Exception;

	User findByAccount(String userAccount)throws Exception;

	User findUserByAccountAndPwd(String userAccount, String userPwd) throws Exception;
	
	List<Menus> findMenus(Integer roleId)throws Exception;


	List<User> queryUser(User user)throws Exception;

	List<User> update(User upUser)throws Exception;

	Integer update1(User upUser) throws Exception;

	Integer deleteUser(String[] ids)throws Exception;

	Integer updateMyInfo(User user)throws Exception;

	List<Salary> querymoney(User user)throws Exception;
	

}
