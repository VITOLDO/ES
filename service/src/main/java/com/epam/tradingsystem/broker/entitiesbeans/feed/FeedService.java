package com.epam.tradingsystem.broker.entitiesbeans.feed;

import com.epam.tradingsystem.broker.entities.FeedMessage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public interface FeedService {

    List<FeedMessage> getMessages();
    void setUrl(String url);
}
