package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.qaportal.model.vo.UserLoginVO;
import com.alacriti.qaportal.resource.UserResource;

public class LogFormDAO extends BaseDAO {
	public LogFormDAO(Connection connection) {
		super(connection);
	}

	public LogFormDAO() {

	}

	public boolean logInRole(UserLoginVO userLoginVO) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean logInFlag = false;

		try {
			String userName = userLoginVO.getUserName();
			String password = userLoginVO.getPassword();
			String sqlCmd = "select password from mounikad_qaportal_logindetails where emailId='"
					+ userName + "'or userName='" + userName + "'";
			System.out.println("inDao");
			stmt = getStatementCheckUserLogin(getConnection(), sqlCmd);
			rs = stmt.executeQuery(sqlCmd);
			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					System.out.println("Successfully Logged in***" + userName);
					logInFlag=true;
				} else {
					System.out.println("Invalid Password");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return logInFlag;

	}

	public Statement getStatementCheckUserLogin(Connection connection,
			String sqlCmd) throws SQLException {
		// log.debugPrintCurrentMethodName();

		System.out.println("getStatement: " + sqlCmd);
		try {

			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception in getStatementCheckUser "
					+ e.getMessage());
			throw e;
		}
	}
}
