package com.epam.tradingsystem.broker.entitiesbeans.usergroup;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.Usergroup;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class UserGroupBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserGroupBean extends GenericBeanImpl<Integer, Usergroup> implements UserGroupBeanRemote, UserGroupBeanLocal {

    /**
     * Default constructor. 
     */
    public UserGroupBean() {
        // TODO Auto-generated constructor stub
    }

}
