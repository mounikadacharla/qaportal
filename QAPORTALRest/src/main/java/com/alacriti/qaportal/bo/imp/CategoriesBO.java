package com.alacriti.qaportal.bo.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.dao.impl.CategoryDAO;
import com.alacriti.qaportal.dao.impl.DAOException;
import com.alacriti.qaportal.model.vo.CategoriesModel;

public class CategoriesBO extends BaseBO {
	public static final Logger log= Logger.getLogger(CategoriesBO.class);
	public CategoriesBO(Connection connection) {
		super(connection);
	}

	public CategoriesBO() {

	}

	public List<CategoriesModel> gettingQuestionsForDifferentCategoriesBO()
			throws BOException, DAOException {
		log.debug("CategoriesBO====>gettingQuestionsForDifferentCategoriesBO");
		try {
			List<CategoriesModel> questionsInBO = new ArrayList<CategoriesModel>();
			CategoryDAO categoryDAO = new CategoryDAO(getConnection());
			questionsInBO = categoryDAO
					.gettingQuestionsFromDifferentategoriesDAO();
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
