package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.model.vo.EditAnswerModel;

public class EdittingAnswerDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(EdittingAnswerDAO.class);
	public EdittingAnswerDAO(Connection connection) {
		super(connection);
	}

	public EdittingAnswerDAO() {

	}

	public void edittingAnswer(EditAnswerModel editAnswerModel)
			throws DAOException {
		log.debug("EdittingAnswerDAO====>edittingAnswer");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(getConnection(),
					"update mounikad_qaportal_answersinformation set answer=? where sid_answer=?");
			stmt.setString(1, editAnswerModel.getAnswer());
			stmt.setInt(2, editAnswerModel.getSid_answer());
			stmt.executeUpdate();
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException("SQLException in EdittingAnswerDAO():", e);
		} finally {
			close(stmt, rs);
		}
	}
}
