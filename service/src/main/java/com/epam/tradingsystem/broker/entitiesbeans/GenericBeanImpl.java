package com.epam.tradingsystem.broker.entitiesbeans;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class GenericBeanImpl<K, E> implements GenericBean<K, E> {
	protected Class<E> entityClass;
	@PersistenceContext(unitName="ForexJPA")
	protected EntityManager entityManager;
	
	protected GenericBeanImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public void create(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public void update(E entity) {
		entityManager.merge(entity);
	}

	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<E> findAll(){
		Query q = entityManager.createQuery("select object(o) from "+entityClass.getName()+" as o");
		return q.getResultList();
	}
}
