package com.alacriti.qaportal.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtility {

	public boolean checkForSession(HttpServletRequest request) {
		HttpSession session= request.getSession(false);
		if (session == null)
			return false;
		else
			return true;
	}
}
