package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.LogFormDAO;
import com.alacriti.qaportal.model.vo.UserLoginVO;

public class LoginBO extends BaseBO {
	public LoginBO(Connection connection) {
		super(connection);
	}
	public LoginBO(){
		
	}
	public boolean loginRoleBO(UserLoginVO loginDetails) throws DAOException, BOException{
		boolean flag=false;
		try {
			LogFormDAO logFormDAO =   new LogFormDAO(getConnection());
			System.out.println("data working");
			flag=logFormDAO.logInRole(loginDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return flag;
	}

}
