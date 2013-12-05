package com.epam.tradingsystem.broker.entitiesbeans.usergroup;

import com.epam.tradingsystem.broker.dao.UsergroupDAO;
import com.epam.tradingsystem.broker.entities.Usergroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UsergroupDAO usergroupDAO;

    @Override
    public Usergroup findUsergroupById(long id) {
        return usergroupDAO.findById(id);
    }

    @Override
    public List<Usergroup> findAllUsergroups() {
        return usergroupDAO.findAll();
    }
}
