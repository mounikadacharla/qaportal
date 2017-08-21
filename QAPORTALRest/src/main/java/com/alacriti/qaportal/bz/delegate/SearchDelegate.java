package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.bo.imp.SearchBO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class SearchDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(SearchDelegate.class);
	public List<QuestionsModel> searchingForQuestions(String wordSearchingFor) {
		log.debug("SearchDelegate====>searchingForQuestions");
		boolean rollback = false;
		Connection connection = null;
		List<QuestionsModel> questionsInSearch = new ArrayList<QuestionsModel>();
		try {
			/* List<String> questionsInHomeDelegate=new ArrayList<String>(); */
			connection = startDBTransaction();
			SearchBO searchBO = new SearchBO(connection);
			questionsInSearch = searchBO
					.searchingForQuestions(wordSearchingFor);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollback = true;
		} finally {
			endDBTransaction(connection, rollback);
		}
		return questionsInSearch;
	}

}
