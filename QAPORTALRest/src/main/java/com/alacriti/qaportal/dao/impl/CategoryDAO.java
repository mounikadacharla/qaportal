package com.alacriti.qaportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.model.vo.CategoriesModel;

public class CategoryDAO extends BaseDAO {
	public static final Logger log= Logger.getLogger(CategoryDAO.class);
	public CategoryDAO(Connection connection) {
		super(connection);
	}

	public CategoryDAO() {

	}

	public List<CategoriesModel> gettingQuestionsFromDifferentategoriesDAO()
			throws DAOException {
		log.debug("In categoriesDAO() -> CategoryDAO");
		List<CategoriesModel> categoriesInDAO = new ArrayList<CategoriesModel>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = getPreparedStatement(getConnection(),
					"SELECT * FROM mounikad_qaportal_topics;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				categoriesInDAO.add(new CategoriesModel(rs.getInt(1), rs
						.getString("category")));
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} finally {
			close(stmt, rs);
		}
		return categoriesInDAO;
	}

}
