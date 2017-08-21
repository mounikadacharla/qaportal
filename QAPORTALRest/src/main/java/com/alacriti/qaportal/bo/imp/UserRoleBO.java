package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.UserDAO;
import com.alacriti.qaportal.model.vo.UserRoleVO;

public class UserRoleBO extends BaseBO {
	public static final Logger log= Logger.getLogger(UserRoleBO.class);

	public UserRoleBO(Connection connection) {
		super(connection);
	}

	public UserRoleBO() {

	}

	public void createUserRole(UserRoleVO userRoleVO) throws DAOException,
			BOException {
		log.debug("UserRoleBO====>createUserRole");
		try {
			UserDAO userDAO = new UserDAO(getConnection());
			System.out.println("data working");
			userDAO.createUserRole(userRoleVO);

		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
	}

}
