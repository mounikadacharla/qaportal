package com.alacriti.qaportal.bz.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.HomeBO;
import com.alacriti.qaportal.model.vo.QuestionsModel;

public class HomeDelegate extends BaseDelegate {
	public static final Logger log= Logger.getLogger(HomeDelegate.class);

	public List<QuestionsModel> movingToHomeDelegate() {
		boolean rollback = false;
		Connection connection = null;
		List<QuestionsModel> questionsInHomeDelegate = new ArrayList<QuestionsModel>();
		try {
			connection = startDBTransaction();
			HomeBO homeBO = new HomeBO(connection);
			questionsInHomeDelegate = homeBO.homePageBO();
		} catch (Exception e) {
			log.error(e.getMessage());
			rollback = true;
		} finally {
			endDBTransaction(connection, rollback);
		}
		return questionsInHomeDelegate;

	}

}
