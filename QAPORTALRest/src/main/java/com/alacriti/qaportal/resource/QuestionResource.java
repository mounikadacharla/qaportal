package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.bz.delegate.AnsweringToAQuestionDelegate;
import com.alacriti.qaportal.bz.delegate.AskQuestionDelegate;
import com.alacriti.qaportal.model.vo.AnsweringToAQuestionModel;
import com.alacriti.qaportal.model.vo.ModelForAskQuestion;

@Path("/")
public class QuestionResource {
	public static final Logger log = Logger.getLogger(QuestionResource.class);

	@POST
	@Path("/askquestion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void askingQuestion(ModelForAskQuestion modelForAskingQuestion) {

		log.debug("in resource====>Ask Question resource");
		AskQuestionDelegate askQuestionDelegate = new AskQuestionDelegate();
		askQuestionDelegate.askingQuestion(modelForAskingQuestion);

	}

	@POST
	@Path("answertoquestion")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean answerToAQuestion(
			AnsweringToAQuestionModel answeringToAQuestionModel) {
		log.debug("AnswerToQuestionResource===>answertoquestionmodel");
		AnsweringToAQuestionDelegate answeringToAQuestionDelegate = new AnsweringToAQuestionDelegate();
		answeringToAQuestionDelegate
				.answeringToAQuestion(answeringToAQuestionModel);
		return true;
	}
}
