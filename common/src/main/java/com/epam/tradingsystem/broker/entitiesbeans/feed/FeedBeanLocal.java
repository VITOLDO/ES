package com.epam.tradingsystem.broker.entitiesbeans.feed;

import java.util.List;

import com.epam.tradingsystem.broker.entities.FeedMessage;

public interface FeedBeanLocal {
	public List<FeedMessage> getMessages();
}
