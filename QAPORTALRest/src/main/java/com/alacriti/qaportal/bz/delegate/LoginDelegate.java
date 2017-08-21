package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.bo.imp.LoginBO;
import com.alacriti.qaportal.model.vo.LoginValidation;
import com.alacriti.qaportal.model.vo.UserLoginVO;

public class LoginDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(LoginDelegate.class);
	public LoginValidation loginRoleBO(UserLoginVO loginDetails) {
		boolean rollBack = false;
		LoginValidation validation=null;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected..in LoginDelegate");
			LoginBO loginBO = new LoginBO(getConnection());
			validation=loginBO.loginRoleBO(loginDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return validation;

	}
}
