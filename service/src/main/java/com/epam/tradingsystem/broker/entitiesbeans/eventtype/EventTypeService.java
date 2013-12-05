package com.epam.tradingsystem.broker.entitiesbeans.eventtype;

import com.epam.tradingsystem.broker.entities.EventType;

import java.util.List;

public interface EventTypeService {

    EventType findEventTypeById(long id);
    List<EventType> findAllEventTypes();
}
