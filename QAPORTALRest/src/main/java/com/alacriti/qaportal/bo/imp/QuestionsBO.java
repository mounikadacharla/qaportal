package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.QuestionsDAO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class QuestionsBO extends BaseBO {
	public static final Logger log= Logger.getLogger(QuestionsBO.class);
	public QuestionsBO(Connection connection) {
		super(connection);
	}

	public QuestionsBO() {

	}

	public List<QuestionsModel> questionsInBO(int questionId)
			throws BOException, DAOException {
		log.debug("QuestionsBO====>questionsInBO");
		try {
			List<QuestionsModel> questionsInBO = new ArrayList<QuestionsModel>();
			QuestionsDAO questionsDAO = new QuestionsDAO(getConnection());
			questionsInBO = questionsDAO.questionsInDAO(questionId);
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
