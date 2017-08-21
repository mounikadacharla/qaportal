package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.model.vo.ModelForAskQuestion;

public class AskQuestionDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(AskQuestionDelegate.class);
	public void askingQuestion(ModelForAskQuestion modelForAskingQuestion) {
		log.debug("AskQuestionDelegate====>askingQuestion");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected");
			AskQuestionBO askQuestionBO = new AskQuestionBO(getConnection());
			askQuestionBO.askingQuestion(modelForAskingQuestion);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
