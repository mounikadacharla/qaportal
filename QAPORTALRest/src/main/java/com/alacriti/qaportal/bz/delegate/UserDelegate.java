package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.UserRoleBO;
import com.alacriti.qaportal.model.vo.UserRoleVO;

public class UserDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(UserDelegate.class);
	public void createUserRole(UserRoleVO userRoleVO) {
		log.debug("UserDelegate====>createUserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected in user delegate");
			UserRoleBO userRoleBO = new UserRoleBO(getConnection());
			userRoleBO.createUserRole(userRoleVO);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			System.out.println("in finally block");
			/*endDBTransaction(connection, rollBack);*/
		}
	}
	public boolean user(String user){
			log.debug("UserDelegate====>user");
			boolean rollBack = false;
			Connection connection = null;
			boolean chekUserExists = false;
			try {
				connection = startDBTransaction();
				setConnection(connection);
				log.debug("database connected in user delegate");
				UserRoleBO userRoleBO = new UserRoleBO(getConnection());
				chekUserExists=userRoleBO.user(user);
			} catch (Exception e) {
				log.error(e.getMessage());
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
				return chekUserExists;
			}
	}
}
