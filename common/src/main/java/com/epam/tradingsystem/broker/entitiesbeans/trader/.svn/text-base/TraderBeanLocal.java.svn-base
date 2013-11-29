package com.epam.tradingsystem.broker.entitiesbeans.trader;
import java.util.List;

import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface TraderBeanLocal extends GenericBean<Integer, Trader>{
	public Trader findTraderByLogin(String login);
	public List<Trader> findAll();
	public List<Trader> findLimited(int first, int last, String fieldToSort, boolean sortOrder);
}
