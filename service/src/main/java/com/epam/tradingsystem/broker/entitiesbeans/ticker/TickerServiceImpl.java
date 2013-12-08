package com.epam.tradingsystem.broker.entitiesbeans.ticker;

import com.epam.tradingsystem.broker.dao.TickerDAO;
import com.epam.tradingsystem.broker.entities.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
@Service("tickerService")
public class TickerServiceImpl implements TickerService {

    @Autowired
    private TickerDAO tickerDAO;

    @Override
    public Ticker findTickerById(long id) {
        return tickerDAO.findById(id);
    }

    @Override
    public List<Ticker> findAllTickers() {
        return tickerDAO.findAll();
    }
}
