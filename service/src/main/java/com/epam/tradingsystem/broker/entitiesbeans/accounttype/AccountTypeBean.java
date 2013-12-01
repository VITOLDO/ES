package com.epam.tradingsystem.broker.entitiesbeans.accounttype;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.AccountType;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class AccountTypeBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountTypeBean extends GenericBeanImpl<Integer, AccountType>
		implements AccountTypeBeanRemote, AccountTypeBeanLocal {

	/**
	 * Default constructor.
	 */
	public AccountTypeBean() {
		// TODO Auto-generated constructor stub
	}

}
