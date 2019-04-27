package com.bjlemon.cost.system.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjlemon.cost.system.user.dao.Userdao;
import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
import com.bjlemon.utils.C3p0Util;

//用户接口实现
public class UserDaoImpl implements Userdao {
 

	@Override		//添加用户
	public Integer insert(User user) throws Exception {
		String sql = "insert into t_user(roleId,userName,userSex,userAge,userPhone,userAccount,userPwd,userSalary,userMark) values(?,?,?,?,?,?,?,?,?)";		
		System.out.println("获取连接MySQL"+sql);
		int row =  C3p0Util.update(sql,
				user.getRoleId(),
				user.getUserName(),
				user.getUserSex(),
				user.getUserAge(),
				user.getUserPhone(),
				user.getUserAccount(),
				user.getUserPwd(),
				user.getUserSalary(),
				0);
		System.out.println("数据库插入数据成功");
		return row;
	}

	@Override  //验证用户
	public User findByAccount(String userAccount) throws Exception {
		String sql="select * from t_user where userAccount=?";
		User user=C3p0Util.queryOne(sql, User.class, userAccount);				
		//返回值为空则可以添加 否则不能添加
		System.out.println("获取用户的账户信息"+user);
		if(user==null){
			//可以添加
			System.out.println("可以添加");
			return user;
		}else{
			//已经存在 不能添加
			System.out.println("不可以添加");
			return user;
		}
		
		


		
	}

	@Override			//验证账号密码是否正确
	public User findUserByAccountAndPwd(String userAccount, String userPwd) throws Exception {
		String sql = "select * from t_user where userAccount=? and userPwd=? "; 
		User user= C3p0Util.queryOne(sql, User.class, userAccount,userPwd);
		return user;
		
	}

	@Override //查询出角色对应菜单
	public List<Menus> findMenus(Integer roleId) throws Exception {
		String sql = "select * from t_menu m ,t_role_menu rm  where m.menuId= rm.menuId and rm.roleId=?";	
		List<Menus> menus = C3p0Util.queryList(sql, Menus.class, roleId);
		return menus;
	}



	@Override			//查询用户信息
	public List<User> queryUser(User user) throws Exception {
		StringBuffer sql=new StringBuffer("select *from t_user u, t_role r where u.roleId=r.roleId and 1=1 and userMark !=-1 ");
//		int i=0;
//		int iw=null;
//		Integer ioo=null;
		ArrayList<Object> values=new ArrayList<Object>();		
		if(user.getUserId()!=null&&user.getUserId()!=0){
			sql.append(" and u.userId=?  ");
			values.add(user.getUserId());
		}
		if(user.getUserName()!=null&& !"".equals(user.getUserName())){
			sql.append(" and u.userName=?  ");
			values.add(user.getUserName());
		}
		System.out.println(sql);		
		List<User> userList = C3p0Util.queryList(sql.toString(), User.class, values.toArray());
		System.out.println("shu chu userList"+userList);
		return userList;
	}

	@Override
	public Integer update1(User p) throws Exception {
		String sql="update t_user set roleId=?,userName=?,userSex=?,userAge=?,userPhone=?,userAccount=?,userPwd=?,userSalary=? where userId=? ";
		System.out.println("修改后的界面显示语句——————————————————————————————————————"+sql);
	Integer row=C3p0Util.update(sql, 
			p.getRoleId(),p.getUserName(),
			p.getUserSex(),p.getUserAge(),
			p.getUserPhone(),p.getUserAccount(),p.getUserPwd(),
			p.getUserSalary(),p.getUserId() );
		
		return row;
	}

	
	@Override
	public List<User> update(User upUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteUser(String[] ids) throws Exception {
		String sql="update t_user set userMark = -1 where userId=?";
		int row=1;
		for(int i=0;i<ids.length;i++ ){
			String id=ids[i];			
			row+=C3p0Util.update(sql, id);
			
		}
		return row;
	}

	@Override
	public Integer updateMyInfo(User p) throws Exception {
		String sql="update t_user set roleId=?,userName=?,userSex=?,userAge=?,userPhone=?,userAccount=?,userPwd=?,userSalary=? where userId=? ";
		System.out.println("修改后的界面显示语句——————————————————————————————————————"+sql);
	Integer row=C3p0Util.update(sql, 
			p.getRoleId(),p.getUserName(),
			p.getUserSex(),p.getUserAge(),
			p.getUserPhone(),p.getUserAccount(),p.getUserPwd(),
			p.getUserSalary(),p.getUserId() );
		System.out.println("修改个人信息的语句"+sql);
		return row;
	}

	@Override
	public List<Salary> querymoney(User user) throws Exception {
		String sql="select * from t_salary_record where userId = ?";
		List<Salary> list= C3p0Util.queryList(sql, Salary.class,user.getUserId() );
		System.out.println(sql+"cha查询工资的sql语句 列表"+list);
		return list;
	}


	}


