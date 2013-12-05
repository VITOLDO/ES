package com.epam.tradingsystem.broker.entitiesbeans.accounttype;

import com.epam.tradingsystem.broker.entities.AccountType;

import java.util.List;

/**
 * Session Bean implementation class AccountTypeService
 */

public interface AccountTypeService {

    AccountType findAccountTypeById(long id);
    List<AccountType> findAllAccountTypes();
}
