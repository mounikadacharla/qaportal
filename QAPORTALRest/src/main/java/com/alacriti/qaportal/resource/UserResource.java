package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.qaportal.bz.delegate.UserDelegate;
import com.alacriti.qaportal.model.vo.UserRoleVO;

@Path("/")
public class UserResource {
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUserRole(UserRoleVO userRoleVO){
		UserDelegate userDelegate = new UserDelegate();
		userDelegate.createUserRole(userRoleVO);
		return Response.status(200).entity(userRoleVO).build();
		
	}

}
