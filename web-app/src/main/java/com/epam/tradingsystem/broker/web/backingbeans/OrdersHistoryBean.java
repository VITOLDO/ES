package com.epam.tradingsystem.broker.web.backingbeans;

import java.util.List;
import javax.ejb.EJB;

import com.epam.tradingsystem.broker.entities.TradingOrder;
import com.epam.tradingsystem.broker.entitiesbeans.tradingorder.TradingOrderBeanLocal;

public class OrdersHistoryBean {

	@EJB
	private TradingOrderBeanLocal tradingOrderBean;

	private int countAllPages;
	private int activePageNumber;
	private int startPosition;
	private int maxResult = 5;

	public int getCountAllPages() {
		try {
			List<TradingOrder> allOrders = tradingOrderBean
					.findAllByUserAccount(UserManageBean.getCurrentUser());
			countAllPages = allOrders.size() / maxResult;
			int remainderDivision = allOrders.size() % maxResult;
			if (remainderDivision > 0) {
				countAllPages++;
			}
		} catch (Exception e) {
			countAllPages = 0;
			e.printStackTrace();
		}
		return countAllPages;
	}

	public int getActivePageNumber() {
		return activePageNumber;
	}

	public void setActivePageNumber(int activePageNumber) {
		this.activePageNumber = activePageNumber;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public List<TradingOrder> getAllOrders() {
		try {
		if ((activePageNumber == 0) || (activePageNumber == 1)) {
			startPosition = 0;
			activePageNumber = 1;
		}
		
			List<TradingOrder> limitOrders = tradingOrderBean.findLimitByUser(
					startPosition, maxResult, UserManageBean.getCurrentUser());
			return limitOrders;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
	     }

	}

	public String getNextPage() {
		if (activePageNumber != countAllPages) {
			startPosition += maxResult;
			activePageNumber++;
		}
		return "ordersHistory";
	}

	public String getPreviousPage() {
		if (activePageNumber > 1) {
			startPosition -= maxResult;
			activePageNumber--;
		}
		return "ordersHistory";
	}

}
