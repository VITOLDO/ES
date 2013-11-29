package com.epam.tradingsystem.broker.web.backingbeans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LogoutBean {

	public String doLogout(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(false);
		httpSession.invalidate();
		
		return "login/login";
	}
	
}
