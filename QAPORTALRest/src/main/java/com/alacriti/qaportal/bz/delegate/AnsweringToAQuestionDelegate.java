package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AnsweringToAQuestionBO;
import com.alacriti.qaportal.model.vo.AnsweringToAQuestionModel;

public class AnsweringToAQuestionDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(AnsweringToAQuestionDelegate.class);
	public void answeringToAQuestion(
			AnsweringToAQuestionModel answeringToAQuestionModel) {
		log.debug("AnsweringToAQuestionDelegate====>answeringToAQuestion");
		boolean rollBack = false;
		Connection connection = null;
		try {
	
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected");
			AnsweringToAQuestionBO answeringToAQuestion = new AnsweringToAQuestionBO(
					getConnection());
			answeringToAQuestion
					.answeringToAQuestion(answeringToAQuestionModel);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}

}
