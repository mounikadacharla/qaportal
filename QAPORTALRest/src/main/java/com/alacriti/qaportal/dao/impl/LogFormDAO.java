package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.model.vo.LoginValidation;
import com.alacriti.qaportal.model.vo.UserLoginVO;

public class LogFormDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(LogFormDAO.class);
	public LogFormDAO(Connection connection) {
		super(connection);
	}

	public LogFormDAO() {

	}

	public LoginValidation logInRole(UserLoginVO userLoginVO) throws DAOException {
		log.debug("LogFormDAO====>logInRole");
		Statement stmt = null;
		ResultSet rs = null;
		LoginValidation validation=null;
		try {
			String userName = userLoginVO.getUserName();
			String password = userLoginVO.getPassword();
			String sqlCmd = "select password,sid from mounikad_qaportal_logindetails where emailId='"
					+ userName + "'or userName='" + userName + "'";
			System.out.println("inDao");
			stmt = getStatementCheckUserLogin(getConnection(), sqlCmd);
			rs = stmt.executeQuery(sqlCmd);
			if (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					System.out.println("Successfully Logged in***" + userName);
					validation=new LoginValidation(rs.getInt("sid"),userName,true);
					
					
					
				} else {
					System.out.println("Invalid Password");
					validation=new LoginValidation(rs.getInt("sid"),userName,false);
					}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException();
		} finally {
			close(stmt);
		}
		return validation;
	}

	public Statement getStatementCheckUserLogin(Connection connection,
			String sqlCmd) throws SQLException {
			

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
