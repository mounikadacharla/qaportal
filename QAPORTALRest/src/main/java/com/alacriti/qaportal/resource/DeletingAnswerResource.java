package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.DeleteAnswerDelegate;
@Path("/")
public class DeletingAnswerResource {
	public static final Logger log= Logger.getLogger(DeletingAnswerResource.class);
	@POST
	@Path("/delete")
	@Consumes(MediaType.TEXT_PLAIN)
	public void deleteAnswer(int sid_answer){
		log.debug("DeletingAnswerResource====>deleteAnswer");
		DeleteAnswerDelegate deleteAnswerDelegate = new DeleteAnswerDelegate();
		deleteAnswerDelegate.deleteAnswer(sid_answer);

	}
}
