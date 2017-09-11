package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserExists extends BaseDAO {
	public static final Logger log= Logger.getLogger(UserExists.class);
	public UserExists(Connection connection){
		super(connection);
	}
	public UserExists(){
		
	}
	public boolean user(String user) throws DAOException{
		log.debug("UserDAO====>user");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean userNameExists=false;
		try{
			stmt = getPreparedStatement(getConnection(), "select sid from mounikad_qaportal_logindetails where userName =?");
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			if(rs.next()){
				userNameExists=true;
				
			}
		}catch(SQLException e){
			log.error(e.getMessage());
			throw new DAOException("SQLException in user():", e);
		}finally{
			close(stmt,rs);
		}
		return userNameExists;
	}

}
