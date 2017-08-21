package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.EdittingAnswerDAO;
import com.alacriti.qaportal.model.vo.EditAnswerModel;

public class EditAnswerDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(EditAnswerDelegate.class);
	public void edittingAnswer(EditAnswerModel editAnswerModel) {
		log.debug("EditAnswerDelegate====>edittingAnswer");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			log.debug("database connected");
			EdittingAnswerDAO edittingAnswerDAO = new EdittingAnswerDAO(
					getConnection());
			edittingAnswerDAO.edittingAnswer(editAnswerModel);
		} catch (Exception e) {
			log.error(e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}

}
