package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.entities.Trader;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
@Controller
public class ChangePassBean {

//	private TraderBeanRemote traderDaoBean;
	private Trader trader;
	private String oldPassword;
	private String newPassword;
	private boolean oldPasswordIn;

	public ChangePassBean() {

	}

	public void checkPassword(FacesContext context, UIComponent component,
			Object value) {
		trader = (Trader) UserManageBean.getCurrentUser();
		if (!trader.getPassword().equals(value)) {
			FacesMessage message = new FacesMessage("Wrong password.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

	public void checkNewPassword(FacesContext context, UIComponent component,
			Object value) {
		if (oldPasswordIn) {
			newPassword = (String) value;
			if (!oldPassword.equals(newPassword)) {
				FacesMessage message = new FacesMessage(
						"Password and confirmPassword fields don't match.");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		} else {
			oldPasswordIn = true;
			oldPassword = (String) value;
		}
	}

	public String changePass() {
//		Trader currentUser  = traderDaoBean.findById(trader.getUserId());
//		currentUser.setPassword(newPassword);
//		traderDaoBean.update(currentUser);
		return "trading";
	}
}
