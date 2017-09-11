package com.alacriti.qaportal.resource;

import javax.ws.rs.Consumes;
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
	public Response addUserRole(UserRoleVO userRoleVO) {
		UserDelegate userDelegate = new UserDelegate();
		userDelegate.createUserRole(userRoleVO);
		return Response.status(200).entity(userRoleVO).build();

	}
	@POST
	@Path("/user")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean user(String user) {
		System.out.println("in user");
		UserDelegate userDelegate = new UserDelegate();
		 return userDelegate.user(user);

	}

}
