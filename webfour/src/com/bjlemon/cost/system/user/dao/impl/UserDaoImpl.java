package com.bjlemon.cost.system.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjlemon.cost.system.user.dao.Userdao;
import com.bjlemon.pojo.Menus;
import com.bjlemon.pojo.Salary;
import com.bjlemon.pojo.User;
import com.bjlemon.utils.C3p0Util;

//�û��ӿ�ʵ��
public class UserDaoImpl implements Userdao {
 

	@Override		//����û�
	public Integer insert(User user) throws Exception {
		String sql = "insert into t_user(roleId,userName,userSex,userAge,userPhone,userAccount,userPwd,userSalary,userMark) values(?,?,?,?,?,?,?,?,?)";		
		System.out.println("��ȡ����MySQL"+sql);
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
		System.out.println("���ݿ�������ݳɹ�");
		return row;
	}

	@Override  //��֤�û�
	public User findByAccount(String userAccount) throws Exception {
		String sql="select * from t_user where userAccount=?";
		User user=C3p0Util.queryOne(sql, User.class, userAccount);				
		//����ֵΪ���������� ���������
		System.out.println("��ȡ�û����˻���Ϣ"+user);
		if(user==null){
			//�������
			System.out.println("�������");
			return user;
		}else{
			//�Ѿ����� �������
			System.out.println("���������");
			return user;
		}
		
		


		
	}

	@Override			//��֤�˺������Ƿ���ȷ
	public User findUserByAccountAndPwd(String userAccount, String userPwd) throws Exception {
		String sql = "select * from t_user where userAccount=? and userPwd=? "; 
		User user= C3p0Util.queryOne(sql, User.class, userAccount,userPwd);
		return user;
		
	}

	@Override //��ѯ����ɫ��Ӧ�˵�
	public List<Menus> findMenus(Integer roleId) throws Exception {
		String sql = "select * from t_menu m ,t_role_menu rm  where m.menuId= rm.menuId and rm.roleId=?";	
		List<Menus> menus = C3p0Util.queryList(sql, Menus.class, roleId);
		return menus;
	}



	@Override			//��ѯ�û���Ϣ
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
		System.out.println("�޸ĺ�Ľ�����ʾ��䡪��������������������������������������������������������������������������"+sql);
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
		System.out.println("�޸ĺ�Ľ�����ʾ��䡪��������������������������������������������������������������������������"+sql);
	Integer row=C3p0Util.update(sql, 
			p.getRoleId(),p.getUserName(),
			p.getUserSex(),p.getUserAge(),
			p.getUserPhone(),p.getUserAccount(),p.getUserPwd(),
			p.getUserSalary(),p.getUserId() );
		System.out.println("�޸ĸ�����Ϣ�����"+sql);
		return row;
	}

	@Override
	public List<Salary> querymoney(User user) throws Exception {
		String sql="select * from t_salary_record where userId = ?";
		List<Salary> list= C3p0Util.queryList(sql, Salary.class,user.getUserId() );
		System.out.println(sql+"cha��ѯ���ʵ�sql��� �б�"+list);
		return list;
	}


	}


