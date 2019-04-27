package com.bjlemon.cost.system.user.service.impl;

import java.util.List;

import com.bjlemon.cost.system.user.dao.Userdao;
import com.bjlemon.cost.system.user.dao.impl.UserDaoImpl;
import com.bjlemon.cost.system.user.service.IUserService;
import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
/**
 * @author Devil·K
 * 用户模块 业务实现
 */
public class UserServiceImpl implements IUserService {

	private Userdao userdao=new UserDaoImpl();
	
	@Override
	public boolean add(User user) throws Exception {		
		Integer row=userdao.insert(user);		
		return row==1?true:false;
	}
	@Override
	public boolean check(String userAccount) throws Exception {
	
	User user=userdao.findByAccount(userAccount);
		return user!=null?true:false;
	}
	
	@Override
	public User login(String userAccount, String userPwd) throws Exception {
		return userdao.findUserByAccountAndPwd(userAccount,userPwd);
		
	}
	@Override
	public List<Menus> findMenus(Integer roleId) throws Exception {
		//return (List<Menus>) userdao.findMenus(roleId);
		return userdao.findMenus(roleId); 
	}
	@Override
	public List<User> checkUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.queryUser(user);
	}
//	@Override
//	public List<User> updateUser(User upUser) throws Exception {
//		
//		return userdao.update(upUser);
//	}
//	
	@Override
	public boolean updateUser1(User upUser) throws Exception {
		// TODO Auto-generated method stub
		int row=userdao.update1(upUser);
		return row==1?true:false;
	}
	@Override
	public boolean delUser(String[] ids) throws Exception {
		int row=userdao.deleteUser(ids);
		return row==ids.length?true:false;
	}
	@Override
	public boolean changeMyInfo(User user) throws Exception {
		int change=userdao.updateMyInfo(user);
		return change!=0?true:false;
	}
	@Override
	public List<Salary> querySalary(User user) throws Exception {
		// TODO Auto-generated method stub
		return userdao.querymoney(user);
	}

	

}
