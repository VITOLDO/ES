package com.epam.tradingsystem.broker.events.commands;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entitiesbeans.event.EventBeanRemote;
import com.epam.tradingsystem.broker.entitiesbeans.eventtype.EventTypeBeanRemote;
import java.util.Date;

public class LoggerCommand implements ICommand {

	public static int ORDER_CREATE = 1;
	public static int ORDER_EXEC = 2;
	public static int ORDER_CANCELED = 3;
	public static int POSITION_CREATE = 4;
	public static int POSITION_EXEC = 5;
	public static int POSITION_CANCELED = 6;
	public static int ACCOUNT_FILL = 7;
	public static int MESSAGE = 8;

	private EventBeanRemote eventBean;
	private EventTypeBeanRemote eventTypeBean;
	private Event event;
	private int eventType;

	public LoggerCommand(Trader trader, int eventType, String message) {
		event = new Event();
		event.setTrader(trader);
		event.setMessage(message);
		this.eventType = eventType;
	}

	@Override
	public void execute() {
		try {
			eventBean = (EventBeanRemote) new InitialContext()
					.lookup("com.epam.tradingsystem.broker.entitiesbeans.event.EventBeanRemote");
			eventTypeBean = (EventTypeBeanRemote) new InitialContext()
					.lookup("com.epam.tradingsystem.broker.entitiesbeans.eventtype.EventTypeBeanRemote");
			if (eventType > 0 && eventType <= 8) {
				event.setEventType(eventTypeBean.findById(eventType));
			} else {
				event.setEventType(eventTypeBean.findById(MESSAGE));
			}
			event.setDate(new Date());
			eventBean.create(event);
		} catch (NamingException e) {
			System.err.println(e);
		}
	}

}
