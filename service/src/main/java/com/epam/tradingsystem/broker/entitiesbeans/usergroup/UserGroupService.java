package com.epam.tradingsystem.broker.entitiesbeans.usergroup;

import com.epam.tradingsystem.broker.entities.Usergroup;

import java.util.List;

public interface UserGroupService {

    Usergroup findUsergroupById(long id);
    List<Usergroup> findAllUsergroups();
}
