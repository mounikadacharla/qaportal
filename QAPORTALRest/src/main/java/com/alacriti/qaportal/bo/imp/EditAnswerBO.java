package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.EdittingAnswerDAO;
import com.alacriti.qaportal.model.vo.EditAnswerModel;

public class EditAnswerBO extends BaseBO {
	public static final Logger log= Logger.getLogger(EditAnswerBO.class);
	public EditAnswerBO(Connection connection) {
		super(connection);
	}

	public EditAnswerBO() {

	}

	public void edittingAnswer(EditAnswerModel editAnswerModel)
			throws BOException, DAOException {
		log.debug("EditAnswerBO====>edittingAnswer");
		try {
			EdittingAnswerDAO edittingAnswer = new EdittingAnswerDAO(
					getConnection());
			edittingAnswer.edittingAnswer(editAnswerModel);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
	}

}
