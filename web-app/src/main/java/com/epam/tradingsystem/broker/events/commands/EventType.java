package com.epam.tradingsystem.broker.events.commands;

public enum EventType {
	ORDER_CREATE, ORDER_EXEC, ORDER_CANCELED,
	POSITION_CREATE, POSITION_EXEC, POSITION_CANCELED,  
	ACCOUNT_FILL
}
