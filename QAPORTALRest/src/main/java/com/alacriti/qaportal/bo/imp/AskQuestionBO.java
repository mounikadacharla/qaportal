package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.AskQuestionDAO;
import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.model.vo.ModelForAskQuestion;

public class AskQuestionBO extends BaseBO {
	public static final Logger log= Logger.getLogger(AskQuestionBO.class);
	public AskQuestionBO(Connection connection) {
		super(connection);
	}

	public AskQuestionBO() {

	}

	public void askingQuestion(ModelForAskQuestion modelForAskingQuestion)
			throws DAOException, BOException {
		log.debug("AskQuestionBO====>askingQuestion");
		try {
			AskQuestionDAO askQuestionDAO = new AskQuestionDAO(getConnection());
			askQuestionDAO.askingQuestionDAO(modelForAskingQuestion);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}

	}

}
