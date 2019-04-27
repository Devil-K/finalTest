package com.bjlemon.test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.bjlemon.utils.C3p0Util;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class TestDemo {

	@Test
	public void testDB() {
		try {
			Connection conn = 	C3p0Util.getConn();
			int row=	C3p0Util.update("insert into t_user(roleId,userName,userSex,userAge,userPhone,userAccount,userPwd,userSalary,userMark) "
					+ "values(?,?,?,?,?,?,?,?,?)",1,'1','ÄÐ',50,'x','y','g',50.00,1);
//			Statement s = (Statement) conn.createStatement();
//			s.executeUpdate("insert into t_user(roleId,userName,userSex,userAge,userPhone,userAccount,userPwd,userSalary,userMark) "
//					+ "values(1,'1','ÄÐ',50,'x','y','g',50.00,1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		ComboPooledDataSource dataSource=new ComboPooledDataSource();
//		try {
////			dataSource.setDriverClass("com.mysql.jdbc.Driver");
////			dataSource.setUser("root");
////			dataSource.setPassword("root");
////			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/webfour");
//			System.out.println(dataSource.getConnection());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
