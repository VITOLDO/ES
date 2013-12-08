package com.epam.tradingsystem.broker.entitiesbeans.trader;

import java.util.List;

import com.epam.tradingsystem.broker.dao.TraderDAO;
import com.epam.tradingsystem.broker.entities.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("traderService")
public class TraderServiceImpl implements TraderService {

	@Autowired
    private TraderDAO traderDAO;

    @Override
    public Trader findTradaerById(long id) {
        return traderDAO.findById(id);
    }

    @Override
	public List<Trader> findAllTraders(){
		return traderDAO.findAll();
	}

    @Override
    public void saveTrader(Trader trader) {
        traderDAO.addNew(trader);
    }

//    @Override
//	public List<Trader> findLimited(int first, int last, String fieldToSort,
//			boolean sortOrder) {
//		Query query = entityManager.createQuery("SELECT t FROM Trader t ");
//		return query.setFirstResult(first).setMaxResults(last).getResultList();
//	}
//
//    @Override
//    public Trader findTraderByLogin(String login) {
//        Query q = entityManager
//                .createQuery("SELECT t FROM Trader t WHERE t.login LIKE :login")
//                .setParameter("login", login);
//        Trader trader;
//        try {
//            trader = (Trader) q.getSingleResult();
//        } catch (NoResultException e) {
//            trader = null;
//        }
//
//        return trader;
//    }

}
