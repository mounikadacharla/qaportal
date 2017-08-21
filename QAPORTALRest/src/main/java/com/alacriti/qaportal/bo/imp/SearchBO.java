package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.SearchDAO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class SearchBO extends BaseBO {
	public static final Logger log= Logger.getLogger(SearchBO.class);
	public SearchBO(Connection connection) {
		super(connection);
	}

	public SearchBO() {

	}

	public List<QuestionsModel> searchingForQuestions(String wordSearchingFor)
			throws BOException, DAOException {
		log.debug("SearchBO====>searchingForQuestions");
		List<QuestionsModel> questionsInSearch = new ArrayList<QuestionsModel>();
		try {
			SearchDAO searchDAO = new SearchDAO(getConnection());
			questionsInSearch = searchDAO
					.searchingForQuestions(wordSearchingFor);
			return questionsInSearch;
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}

	}

}
