package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.CategoriesBO;
import com.alacriti.qaportal.model.vo.CategoriesModel;

public class CategoriesDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(CategoriesDelegate.class);
	public List<CategoriesModel> movingToCategoriesDelegate() {
		log.debug("CategoriesDelegate====>movingToCategoriesDelegate");
		boolean rollback = false;
		Connection connection = null;
		List<CategoriesModel> categoriesInDelegate = new ArrayList<CategoriesModel>();
		try {
			connection = startDBTransaction();
			CategoriesBO categoriesBO = new CategoriesBO(connection);
			categoriesInDelegate = categoriesBO
					.gettingQuestionsForDifferentCategoriesBO();
		} catch (Exception e) {
			log.error(e.getMessage());
			rollback = true;

		} finally {
			endDBTransaction(connection, rollback);
		}
		return categoriesInDelegate;

	}
}
