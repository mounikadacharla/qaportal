package com.alacriti.qaportal.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.qaportal.bz.delegate.LoginDelegate;
import com.alacriti.qaportal.model.vo.UserLoginVO;
@Path("/")
public class LoginResource {
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public  boolean loginRole(UserLoginVO loginDetails){
		LoginDelegate loginDelegate=new LoginDelegate();
		
		return loginDelegate.loginRoleBO(loginDetails); //Response.status(200).entity(loginDetails).build();
		
	}

}
