package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.DeleteAnswerDAO;

public class DeletingAnswerBO extends BaseBO {
	public static final Logger log= Logger.getLogger(DeletingAnswerBO.class);
	public DeletingAnswerBO(Connection connection){
		super(connection);
	}
	public DeletingAnswerBO(){
		
	}
	public void deleteAnswer(int sid_answer) throws DAOException, BOException{
		log.debug("DeletingAnswerBO====>deleteAnswer");
		try {
			DeleteAnswerDAO deletingAnswer = new DeleteAnswerDAO(
					getConnection());
			deletingAnswer.deletingAnswer(sid_answer);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
		
		
	}

}
