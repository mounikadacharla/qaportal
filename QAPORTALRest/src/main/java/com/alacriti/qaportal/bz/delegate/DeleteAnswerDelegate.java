package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.DeletingAnswerBO;

public class DeleteAnswerDelegate extends BaseDelegate{
	public static final Logger log= Logger.getLogger(DeleteAnswerDelegate.class);
	public void deleteAnswer(int sid_answer){
		log.debug("DeleteAnswerDelegate====>deleteAnswer");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected");
			DeletingAnswerBO deletingAnswer = new DeletingAnswerBO(
					getConnection());
			deletingAnswer.deleteAnswer(sid_answer);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}

}
