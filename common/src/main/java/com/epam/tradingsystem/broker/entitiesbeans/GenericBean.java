package com.epam.tradingsystem.broker.entitiesbeans;

import java.util.List;

public interface GenericBean<K, E> {
	void create(E entity);
	void remove(E entity);
	void update(E entity);
	E findById(K id);
	public List<E> findAll();
}
