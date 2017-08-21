package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.dao.impl.HomeDAO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class HomeBO extends BaseBO {
	public static final Logger log= Logger.getLogger(HomeBO.class);
	public HomeBO(Connection connection) {
		super(connection);
	}

	public HomeBO() {

	}

	public List<QuestionsModel> homePageBO() throws DAOException, BOException {
		List<QuestionsModel> questionsInBO = new ArrayList<QuestionsModel>();
		log.debug("HomeBO====>homePageBO");
		try {
			HomeDAO homeDAO = new HomeDAO(getConnection());
			questionsInBO = homeDAO.homeDetailsDAO();
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new BOException();
		}
		return questionsInBO;
	}

}
