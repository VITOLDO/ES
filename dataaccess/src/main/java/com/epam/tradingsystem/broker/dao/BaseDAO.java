package com.epam.tradingsystem.broker.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 04.12.13
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDAO<T> {
    T findById(long id);
    List<T> findAll();
    void addNew(T object);
    void update(T object);
}
