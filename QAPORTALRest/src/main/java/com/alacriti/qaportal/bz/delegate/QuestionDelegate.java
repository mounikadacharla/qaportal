package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.QuestionsBO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class QuestionDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(QuestionDelegate.class);
	public List<QuestionsModel> questionsFromDelegate(int questionId) {
		log.debug("QuestionDelegate====>questionsFromDelegate");
		boolean rollback = false;
		Connection connection = null;
		List<QuestionsModel> questionsInDelegate = new ArrayList<QuestionsModel>();
		try {
			/* List<String> questionsInHomeDelegate=new ArrayList<String>(); */
			connection = startDBTransaction();
			QuestionsBO questionsBO = new QuestionsBO(connection);
			System.out.println("in delegate");
			questionsInDelegate = questionsBO.questionsInBO(questionId);
			System.out.println("Still in delegate");
		} catch (Exception e) {
			log.error(e.getMessage());
			rollback = true;
		} finally {
			endDBTransaction(connection, rollback);
		}
		return questionsInDelegate;

	}

}
