package com.alacriti.qaportal.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.AnswersDelegate;
import com.alacriti.qaportal.bz.delegate.CategoriesDelegate;
import com.alacriti.qaportal.bz.delegate.QuestionDelegate;
import com.alacriti.qaportal.model.vo.AnswersModel;
import com.alacriti.qaportal.model.vo.CategoriesModel;
import com.alacriti.qaportal.model.vo.QuestionsModel;

@Path("/")
public class CategoryResource {
	public static final Logger log= Logger.getLogger(CategoryResource.class);
	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriesModel> gettingDifferentCategories() {
		log.debug("CategoryResource====>gettingDifferentCategories");
		CategoriesDelegate categoriesDelegate = new CategoriesDelegate();
		return categoriesDelegate.movingToCategoriesDelegate();

	}

	@POST
	@Path("/id")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionsModel> questionsInDifferentCategories(int questionId) {
		log.debug("CategoryResource====>questionsInDifferentCategories");
		QuestionDelegate questionDelegate = new QuestionDelegate();
		return questionDelegate.questionsFromDelegate(questionId);
	}
	
	@POST
	@Path("/questionId")
//	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String questionForAnswers(int questionId) {
		log.debug("CategoryResource====>questionForAnswers");
		QuestionDelegate questionDelegate = new QuestionDelegate();
		return questionDelegate.questionForAnswers(questionId);
	}

	@POST
	@Path("/answers")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<AnswersModel> answersForQuestions(int questionId) {
		log.debug("CategoryResource====>answersForQuestions");
		AnswersDelegate answersDelegate = new AnswersDelegate();
		return answersDelegate.answersInDelegate(questionId);
	}

}
