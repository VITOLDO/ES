package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.FeedMessageDAO;
import com.epam.tradingsystem.broker.entities.FeedMessage;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
public class FeedMessageDAOImpl extends BaseDAOImpl<FeedMessage> implements FeedMessageDAO {
    public FeedMessageDAOImpl() {
        setClazz(FeedMessage.class);
    }
}
