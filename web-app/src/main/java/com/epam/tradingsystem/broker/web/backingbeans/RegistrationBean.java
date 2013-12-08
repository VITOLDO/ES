package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.entities.Trader;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@Controller
public class RegistrationBean {

	private Trader trader = new Trader();
	private int countryId;
//	@EJB
//	private TraderBeanRemote userDaoBean;
//	@EJB
//	private CountryBeanRemote countryDaoBean;
	
	
	
	public RegistrationBean() {
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void checkLogin(FacesContext context, UIComponent component, Object value) {
		String login = value.toString();
//		if (userDaoBean.findTraderByLogin(login) != null) {
//			FacesMessage message = new FacesMessage("User with this name already exist.");
//			message.setSeverity(FacesMessage.SEVERITY_ERROR);
//			throw new ValidatorException(message);
//		}
		
		context.renderResponse();
	}
	
	public void checkPassword(FacesContext context, UIComponent component, Object value) {
		String confirmedPassword = value.toString();
		if (trader.getPassword() != confirmedPassword) {
			FacesMessage message = new FacesMessage("Password and confirmPassword fields don't match.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
		context.renderResponse();
	}
	
//	public List<Country> getCountriesList() {
//		return countryDaoBean.findAll();
//	}
//
//	public String createNewUser() {
//		trader.setCountry(countryDaoBean.findById(countryId));
//		userDaoBean.create(trader);
//
//		return "login";
//	}
}
