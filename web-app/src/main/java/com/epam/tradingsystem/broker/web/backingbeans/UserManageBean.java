package com.epam.tradingsystem.broker.web.backingbeans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.epam.tradingsystem.broker.entities.Trader;
import org.springframework.stereotype.Controller;

@Controller
public class UserManageBean {

	public static Trader getCurrentUser() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				true);
		return (Trader) session.getAttribute("currentUser");
	}

}
