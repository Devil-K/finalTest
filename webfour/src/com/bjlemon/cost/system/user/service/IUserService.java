package com.bjlemon.cost.system.user.service;

import java.util.List;

import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

public interface IUserService {  //业务接口 


	boolean add(User user) throws Exception;//添加用户方法

	boolean check(String userAccount) throws Exception;//验证是否重名

	User login(String userAccount, String userPwd) throws Exception ;

	List<Menus> findMenus(Integer roleId)throws Exception;

	List<User> checkUser(User user)throws Exception;

//	List<User> updateUser(User upUser) throws Exception;

	boolean updateUser1(User upUser) throws Exception;

	boolean delUser(String[] ids) throws Exception;

	boolean changeMyInfo(User user)throws Exception;

	List<Salary> querySalary(User user)throws Exception;

//	List<Salary> querySalary(Object user)throws Exception;



	

	
}
