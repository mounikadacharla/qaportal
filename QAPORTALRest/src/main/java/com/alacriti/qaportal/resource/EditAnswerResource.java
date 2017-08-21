package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.EditAnswerDelegate;
import com.alacriti.qaportal.dao.impl.EdittingAnswerDAO;
import com.alacriti.qaportal.model.vo.EditAnswerModel;

@Path("/")
public class EditAnswerResource {
	public static final Logger log= Logger.getLogger(EditAnswerResource.class);
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void edittingAnswer(EditAnswerModel editAnswerModel) {
		log.debug("EditAnswerResource====>edittingAnswer");
		EditAnswerDelegate editAnswerDelegate = new EditAnswerDelegate();
		editAnswerDelegate.edittingAnswer(editAnswerModel);

	}

}
