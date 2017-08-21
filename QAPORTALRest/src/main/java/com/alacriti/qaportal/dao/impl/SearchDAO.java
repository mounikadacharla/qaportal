package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.model.vo.QuestionsModel;

public class SearchDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(SearchDAO.class);
	public SearchDAO(Connection connection) {
		super(connection);
	}

	public SearchDAO() {

	}

	public List<QuestionsModel> searchingForQuestions(String wordSearchingFor)
			throws DAOException {
		log.debug("SearchDAO====>searchingForQuestions");
		List<QuestionsModel> questionsInSearch = new ArrayList<QuestionsModel>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(
					getConnection(),
					"select q.sid_question,l.userName,q.question,q.postedtime from mounikad_qaportal_tableforquestions as q inner join mounikad_qaportal_logindetails as l on q.sid_person=l.sid where q.question like ? ORDER BY q.postedtime desc;");
			stmt.setString(1, "%" + wordSearchingFor + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				questionsInSearch.add(new QuestionsModel(rs.getInt(1),rs.getString("userName"),rs.getString("question"), rs.getDate("postedTime")));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} finally {
			close(stmt, rs);
		}
		return questionsInSearch;
	}

}
