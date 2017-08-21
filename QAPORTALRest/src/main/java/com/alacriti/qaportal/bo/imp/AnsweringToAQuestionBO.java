package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.AnsweringToAQuestionDAO;
import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.model.vo.AnsweringToAQuestionModel;

public class AnsweringToAQuestionBO extends BaseBO {
	public static final Logger log = Logger
			.getLogger(AnsweringToAQuestionBO.class);

	public AnsweringToAQuestionBO(Connection connection) {
		super(connection);
	}

	public AnsweringToAQuestionBO() {

	}

	public void answeringToAQuestion(
			AnsweringToAQuestionModel answeringToAQuestionModel)
			throws BOException, DAOException {
		log.debug("AnsweringToAQuestionBO====>answeringToAQuestion");
		try {
			AnsweringToAQuestionDAO answeringToAQuestionDAO = new AnsweringToAQuestionDAO(
					getConnection());
			answeringToAQuestionDAO
					.answeringToAQuestion(answeringToAQuestionModel);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
	}

}
