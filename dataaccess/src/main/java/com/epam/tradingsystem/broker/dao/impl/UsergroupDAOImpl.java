package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.UsergroupDAO;
import com.epam.tradingsystem.broker.entities.Usergroup;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class UsergroupDAOImpl extends BaseDAOImpl<Usergroup> implements UsergroupDAO {
    public UsergroupDAOImpl() {
        setClazz(Usergroup.class);
    }
}
