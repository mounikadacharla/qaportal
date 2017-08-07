package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.UserDAO;
import com.alacriti.qaportal.model.vo.UserRoleVO;


public class UserRoleBO extends BaseBO {
	
	public UserRoleBO(Connection connection) {
		super(connection);
	}
	public UserRoleBO(){
		
	}
	public void createUserRole(UserRoleVO userRoleVO) throws DAOException, BOException{
		
		try {
			UserDAO userDAO =   new UserDAO(getConnection());
			System.out.println("data working");
			userDAO.createUserRole(userRoleVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

}
