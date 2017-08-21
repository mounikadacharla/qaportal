package com.alacriti.qaportal.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.SearchDelegate;
import com.alacriti.qaportal.model.vo.QuestionsModel;

@Path("/")
public class SearchResource {
	public static final Logger log= Logger.getLogger(SearchResource.class);
	@POST
	@Path("/search")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionsModel> searchingForQuestions(String wordSearchingFor) {
		log.debug("SearchResource====>searchingForQuestions");
		SearchDelegate searchDelegate = new SearchDelegate();
		return searchDelegate.searchingForQuestions(wordSearchingFor);

	}

}
