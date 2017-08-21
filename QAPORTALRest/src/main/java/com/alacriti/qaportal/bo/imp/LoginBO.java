package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.LogFormDAO;
import com.alacriti.qaportal.model.vo.LoginValidation;
import com.alacriti.qaportal.model.vo.UserLoginVO;

public class LoginBO extends BaseBO {
	public static final Logger log= Logger.getLogger(LoginBO.class);
	public LoginBO(Connection connection) {
		super(connection);
	}

	public LoginBO() {

	}

	public LoginValidation loginRoleBO(UserLoginVO loginDetails) throws DAOException,
			BOException {
		log.debug("LoginBO====>loginRoleBO");
		LoginValidation validation=null;
		try {
			LogFormDAO logFormDAO = new LogFormDAO(getConnection());
			System.out.println("data working");
			validation= logFormDAO.logInRole(loginDetails);

		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
		return validation;
	}

}
