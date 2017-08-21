package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.model.vo.ModelForAskQuestion;

public class AskQuestionDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(AskQuestionDAO.class);
	public AskQuestionDAO(Connection connection) {
		super(connection);

	}

	public AskQuestionDAO() {

	}

	public void askingQuestionDAO(ModelForAskQuestion modelForAskingQuestion)
			throws DAOException {
		log.debug("AskQuestionDAO====>askingQuestionDAO");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(
					getConnection(),
					"insert into mounikad_qaportal_tableforquestions(sid_topic,sid_person,question) values(?,?,?)");
			stmt.setInt(1, modelForAskingQuestion.getSid_topic());
			stmt.setInt(2, modelForAskingQuestion.getSid_person());
			stmt.setString(3, modelForAskingQuestion.getQuestion());
			log.debug("======>" + modelForAskingQuestion.getQuestion());
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException("SQLExceptionin askingQuestion:", e);
		} finally {
			close(stmt, rs);
		}
	}

}
