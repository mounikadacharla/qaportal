package com.alacriti.qaportal.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.HomeDelegate;
import com.alacriti.qaportal.model.vo.QuestionsModel;

@Path("/")
public class HomeResource {
	public static final Logger log= Logger.getLogger(HomeResource.class);
	@GET
	@Path("home")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionsModel> homeResource() {
		log.debug("HomeResource====>homeResource");
		HomeDelegate homeDelegate = new HomeDelegate();
		return homeDelegate.movingToHomeDelegate();
	}

}
