package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.FeedMessageDAO;
import com.epam.tradingsystem.broker.entities.FeedMessage;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class FeedMessageDAOImpl extends BaseDAOImpl<FeedMessage> implements FeedMessageDAO {
    public FeedMessageDAOImpl() {
        setClazz(FeedMessage.class);
    }
}
