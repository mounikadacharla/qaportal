package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AnswersInBO;
import com.alacriti.qaportal.model.vo.AnswersModel;

public class AnswersDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(AnswersDelegate.class);
	public List<AnswersModel> answersInDelegate(int questionId) {
		log.debug("AnswersDelegate====>answersInDelegate");
		boolean rollback = false;
		Connection connection = null;
		List<AnswersModel> answersFromDelegate = new ArrayList<AnswersModel>();
		try {
			connection = startDBTransaction();
			AnswersInBO answersBO = new AnswersInBO(connection);
			log.debug("in delegate");
			answersFromDelegate = answersBO.answersInBO(questionId);
			log.debug("Still in delegate");
		} catch (Exception e) {
			log.error(e.getMessage());
			rollback = true;
		} finally {
			endDBTransaction(connection, rollback);
		}
		return answersFromDelegate;

	}

}
