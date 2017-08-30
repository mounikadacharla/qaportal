package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.model.vo.AnswersModel;

public class AnswersDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(AnswersDAO.class);
	public AnswersDAO(Connection connection) {
		super(connection);
	}

	public AnswersDAO() {

	}

	public List<AnswersModel> answersInDAO(int questionId) throws DAOException {
		log.debug("AnswerInDAO====>answersInDAO");
		List<AnswersModel> answersInDAO = new ArrayList<AnswersModel>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(
					getConnection(),
					"select a.sid_answer,l.userName,a.answer,a.postedtime,a.sid_person from"
					+" mounikad_qaportal_answersinformation as a inner join mounikad_qaportal_logindetails as l"
							+" on a.sid_person=l.sid where a.sid_question=? order by a.postedtime desc;");
			stmt.setInt(1, questionId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				answersInDAO.add(new AnswersModel(rs.getInt(1),rs.getString("userName"),rs.getString("answer"), rs
						.getDate("postedTime"),rs.getInt(5)));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} finally {
			close(stmt, rs);
		}
		return answersInDAO;
	}

}
