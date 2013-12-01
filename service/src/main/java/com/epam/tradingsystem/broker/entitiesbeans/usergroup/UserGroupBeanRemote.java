package com.epam.tradingsystem.broker.entitiesbeans.usergroup;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Usergroup;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface UserGroupBeanRemote extends GenericBean<Integer, Usergroup>{

}
