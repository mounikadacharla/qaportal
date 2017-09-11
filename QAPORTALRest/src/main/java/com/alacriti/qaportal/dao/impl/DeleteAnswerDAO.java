package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DeleteAnswerDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(DeleteAnswerDAO.class);
	public DeleteAnswerDAO(Connection connection){
		super(connection);
	}
	public DeleteAnswerDAO(){
		
	}
	public void deletingAnswer(int sid_answer) throws DAOException{
		log.debug("DeleteAnswerDAO====>deletingAnswer");
		log.debug("sid_answer"+sid_answer);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = getPreparedStatement(
					getConnection(),
					"UPDATE mounikad_qaportal_answersinformation"
						+" SET status=0 WHERE sid_answer=?;");
			log.debug("sid_answer="+sid_answer);
			stmt.setInt(1, sid_answer);
			stmt.executeUpdate();
		}catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} finally {
			close(stmt, rs);
		}
	}
}
