package com.alacriti.qaportal.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.qaportal.util.SessionUtility;

@Path("/")
public class SessionResource {
	public static final Logger log= Logger.getLogger(SessionResource.class);
	@GET
	@Path("checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean SessionResource(@Context HttpServletRequest request) {
		log.debug("SessionResource====>SessionResource");
		SessionUtility sessionUtility = new SessionUtility();
		// HttpSession session = request.getSession(false);
		// System.out.println("session in checkSession :" + session);
		return sessionUtility.checkForSession(request);
	}

	@GET
	@Path("/sessionDestroy")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean sessoinDestroy(@Context HttpServletRequest request) {
		log.debug("SessionResource====>sessoinDestroy");
		boolean result = false;
		SessionUtility sessionUtility = null;
		//HttpSession session = null;
		try {
			sessionUtility = new SessionUtility();
			HttpSession session = request.getSession();
			System.out.println("session in checkSession :" + session);
			session.invalidate();
			System.out.println("Checking for session "+session);
			result = sessionUtility.checkForSession(request);
		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println("Exception occured in destroying session");
		}
		System.out.println("result");
		return result;
		
	}

}
