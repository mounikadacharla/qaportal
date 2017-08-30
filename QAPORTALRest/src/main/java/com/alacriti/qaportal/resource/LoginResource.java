package com.alacriti.qaportal.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.bz.delegate.LoginDelegate;
import com.alacriti.qaportal.model.vo.LoginValidation;
import com.alacriti.qaportal.model.vo.UserLoginVO;

@Path("/")
public class LoginResource {
	public static final Logger log= Logger.getLogger(LoginResource.class);
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginValidation loginRole(UserLoginVO loginDetails,
			@Context HttpServletRequest request) {
		log.debug("LoginResource====>loginRole");
		LoginDelegate loginDelegate = new LoginDelegate();
		HttpSession session = request.getSession();
		return loginDelegate.loginRoleBO(loginDetails);
	}

}
