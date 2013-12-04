package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 04.12.13
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */

public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    private Class<T> clazz;

    @Override
    public T findById(long id) {
        return (T) hibernateTemplate.get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return hibernateTemplate.find("from " + clazz.getName());
    }

    @Override
    public void addNew(T object) {
        hibernateTemplate.save(object);
    }

    @Override
    public void update(T object) {
        hibernateTemplate.update(object);
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
