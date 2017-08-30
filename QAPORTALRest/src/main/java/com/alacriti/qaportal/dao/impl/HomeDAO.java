package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.qaportal.model.vo.QuestionsModel;

public class HomeDAO extends BaseDAO {
	public HomeDAO(Connection connection) {
		super(connection);
	}

	public HomeDAO() {

	}

	public List<QuestionsModel> homeDetailsDAO() throws DAOException {
		log.debug("In homeDetailsDAO() -> HomeDAO");
		List<QuestionsModel> questions = new ArrayList<QuestionsModel>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(
					getConnection(),
					"select q.sid_question,l.userName,q.question,q.postedtime from mounikad_qaportal_tableforquestions as q inner join mounikad_qaportal_logindetails as l on q.sid_person=l.sid ORDER BY q.postedtime desc");
			rs = stmt.executeQuery();
			while (rs.next()) {
				questions.add(new QuestionsModel(rs.getInt(1),rs.getString("userName"),rs.getString("question"), rs.getDate("postedTime")));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} finally {
			close(stmt, rs);
		}
		return questions;
	}
}
