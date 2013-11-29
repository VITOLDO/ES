package com.epam.tradingsystem.broker.entitiesbeans.usergroup;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Usergroup;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface UserGroupBeanLocal  extends GenericBean<Integer, Usergroup>{

}
