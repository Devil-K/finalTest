package com.bjlemon.cost.system.user.service;

import java.util.List;

import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;

public interface IUserService {  //ҵ��ӿ� 


	boolean add(User user) throws Exception;//����û�����

	boolean check(String userAccount) throws Exception;//��֤�Ƿ�����

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
