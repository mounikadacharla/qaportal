package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bo.imp.AskQuestionBO;
import com.alacriti.qaportal.bz.delegate.AnsweringToAQuestionDelegate;
import com.alacriti.qaportal.model.vo.AnsweringToAQuestionModel;

@Path("/")
public class AnswerToAQuestionResource {
	public static final Logger log= Logger.getLogger(AnswerToAQuestionResource.class);
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
