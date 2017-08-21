package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.model.vo.AnsweringToAQuestionModel;

public class AnsweringToAQuestionDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(AnsweringToAQuestionDAO.class);
	public AnsweringToAQuestionDAO(Connection connection) {
		super(connection);
	}

	public AnsweringToAQuestionDAO() {

	}

	public void answeringToAQuestion(
			AnsweringToAQuestionModel answeringToAQuestionModel)
			throws DAOException {
		log.debug("AnsweringToAQuestionDAO====>answeringToAQuestion");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("Before prepared statement");
			stmt = getPreparedStatement(
					getConnection(),
					"insert into mounikad_qaportal_answersinformation(sid_question,sid_person,answer) values(?,?,?)");
			stmt.setInt(1, answeringToAQuestionModel.getSid_question());
			stmt.setInt(2, answeringToAQuestionModel.getSid_person());
			stmt.setString(3, answeringToAQuestionModel.getAnswer());
			log.debug("after prepared statement");
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException(
					"SQLException in answering to a question DAO:", e);
		} finally {
			close(stmt, rs);
		}
	}

}
