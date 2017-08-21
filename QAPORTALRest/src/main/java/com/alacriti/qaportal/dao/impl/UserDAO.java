package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.model.vo.UserRoleVO;

public class UserDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(UserDAO.class);
	public UserDAO(Connection conn) {
		super(conn);
	}

	public UserDAO() {

	}

	public void createUserRole(UserRoleVO userRoleVO) throws DAOException {
		log.debug("UserDAO====>createUserRole");
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sqlcmd";

			stmt = getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			System.out.println("mouni error");
			stmt.setString(1, userRoleVO.firstName);
			stmt.setString(2, userRoleVO.lastName);
			stmt.setString(3, userRoleVO.emailId);
			stmt.setString(4, userRoleVO.userName);
			stmt.setString(5, userRoleVO.password);

			stmt.executeUpdate();

		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementCreateUserRole(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("insert into mounikad_qaportal_logindetails(firstName,lastName,emailId,userName,password) values(?,?,?,?,?)");
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}
