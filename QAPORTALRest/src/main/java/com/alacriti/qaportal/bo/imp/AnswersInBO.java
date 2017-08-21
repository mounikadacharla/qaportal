package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.AnswersDAO;
import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.model.vo.AnswersModel;

public class AnswersInBO extends BaseBO {
	public static final Logger log= Logger.getLogger(AnswersInBO.class);
	public AnswersInBO(Connection connection) {
		super(connection);
	}

	public AnswersInBO() {

	}

	public List<AnswersModel> answersInBO(int questionId) throws DAOException,
			BOException {
		log.debug("AnswersinBo===>answersInBO");
		List<AnswersModel> questionsInBO = new ArrayList<AnswersModel>();
		try {
			AnswersDAO answersDAO = new AnswersDAO(getConnection());
			questionsInBO = answersDAO.answersInDAO(questionId);
			return questionsInBO;
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}

	}

}
