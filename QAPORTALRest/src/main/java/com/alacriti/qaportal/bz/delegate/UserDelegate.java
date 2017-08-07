package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import com.alacriti.qaportal.bo.imp.UserRoleBO;
import com.alacriti.qaportal.model.vo.UserRoleVO;
public class UserDelegate extends BaseDelegate {
	public void createUserRole(UserRoleVO userRoleVO){
		boolean rollBack=false;
		Connection connection=null;
		try{
		connection = startDBTransaction();
		setConnection(connection);
		System.out.println("database connect6ed");
		UserRoleBO userRoleBO=new UserRoleBO(getConnection());
		userRoleBO.createUserRole(userRoleVO);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
