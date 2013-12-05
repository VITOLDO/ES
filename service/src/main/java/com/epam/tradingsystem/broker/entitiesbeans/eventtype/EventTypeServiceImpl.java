package com.epam.tradingsystem.broker.entitiesbeans.eventtype;

import com.epam.tradingsystem.broker.dao.EventTypeDAO;
import com.epam.tradingsystem.broker.entities.EventType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeDAO eventTypeDAO;

    @Override
    public EventType findEventTypeById(long id) {
        return eventTypeDAO.findById(id);
    }

    @Override
    public List<EventType> findAllEventTypes() {
        return eventTypeDAO.findAll();
    }
}
