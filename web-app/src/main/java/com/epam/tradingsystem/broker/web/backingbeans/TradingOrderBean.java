package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.entities.OrderOperation;
import com.epam.tradingsystem.broker.entities.Ticker;
import com.epam.tradingsystem.broker.entitiesbeans.orderoperation.OrderOperationService;
import com.epam.tradingsystem.broker.entitiesbeans.ticker.TickerService;
import com.epam.tradingsystem.broker.entitiesbeans.tradingorder.TradingOrderService;
import com.epam.tradingsystem.broker.rate.ejb.RateEJBLocal;
import com.epam.tradingsystem.broker.rate.quotes.Quote;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TradingOrderBean {

	@Autowired
	private TradingOrderService tradingOrderService;
	@Autowired
	private TickerService tickerService;
	@Autowired
	private OrderOperationService orderOperationService;

    @Autowired
    private RateEJBLocal rateBean;

	public TradingOrderBean() {

	}

	private Map<String, Object> typeOperationValues;
	private Map<String, Object> ozValues;
	private Map<String, Object> typeOrderValues;
	private Map<String, Object> tickerValues;
	private int tickerId;
	private float oz;
	private double sl;
	private double tp;
	private String typeOrder;
	private int typeOperation;
	private double price;

	public double getPrice() {
		try {
			getCurrentRatePrice();
		} catch (NullPointerException e) {
			this.price = 0;
		}
		return price;
	}

	public Map<String, Object> getTypeOperationValues() {
		List<OrderOperation> orderOperationList = orderOperationService.findAllOrderOperations();
		typeOperationValues = new LinkedHashMap<String, Object>();
		for (OrderOperation orderOperation : orderOperationList) {
			typeOperationValues.put(orderOperation.getName(), orderOperation.getOrderOperationId());
		}
		return typeOperationValues;
		
	}

	public void setPrice(double price) {
		try {
			getCurrentRatePrice();
		} catch (NullPointerException e) {
			Logger.getLogger("file_log").log(Level.SEVERE, e.toString());
			this.price = 0;
		}
	}

	public int getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(int typeOperation) {
		this.typeOperation = typeOperation;
	}

	public int getTickerId() {
		return tickerId;
	}

	public void setTickerId(int tickerId) {
		this.tickerId = tickerId;
	}

	public float getOz() {
		return oz;
	}

	public void setOz(float oz) {
		this.oz = oz;
	}

	public double getSl() {
		return sl;
	}

	public void setSl(double sl) {
		this.sl = sl;
	}

	public double getTp() {
		return tp;
	}

	public void setTp(float tp) {
		this.tp = tp;
	}

	public String getTypeOrder() {
		return typeOrder;
	}

	public void setTypeOrder(String typeOrder) {
		this.typeOrder = typeOrder;
	}

	public Map<String, Object> getOzValues() {
		ozValues = new LinkedHashMap<String, Object>();
		ozValues.put("1", "1");
		ozValues.put("0.9", "0.9");
		ozValues.put("0.8", "0.8");
		ozValues.put("0.7", "0.7");
		ozValues.put("0.6", "0.6");
		ozValues.put("0.5", "0.5");
		ozValues.put("0.4", "0.4");
		ozValues.put("0.3", "0.3");
		ozValues.put("0.2", "0.2");
		ozValues.put("0.1", "0.1");
		return ozValues;
	}

	public Map<String, Object> getTickerValues() {
		List<Ticker> tickersList = tickerService.findAllTickers();
		tickerValues = new LinkedHashMap<String, Object>();
		for (Ticker ticker : tickersList) {
			tickerValues.put(ticker.getName(), ticker.getTickerId());
		}
		return tickerValues;
	}

	public Map<String, Object> getTypeOrderValues() {
		// connect to TypeOrderBean and findAll() (TypeOrder bean not created)
		// stub
		String TYPE_ORDER_INSTANT = "Instant";
		String TYPE_ORDER_NOT_INSTANT = "Not Instant";
		typeOrderValues = new LinkedHashMap<String, Object>();
		typeOrderValues.put(TYPE_ORDER_INSTANT, TYPE_ORDER_INSTANT);
		typeOrderValues.put(TYPE_ORDER_NOT_INSTANT, TYPE_ORDER_NOT_INSTANT);
		return typeOrderValues;
	}

	private void getCurrentRatePrice() {

		// recode
		// stub
		List<Quote> listRates = rateBean.getLastQuotes();
		Ticker activeTicker = tickerService.findTickerById(1);// add check selected Ticker
		for (Quote quote : listRates) {
			if (quote != null && quote.getCode().equals(activeTicker.getName())) {
				// add check selected Ticker
				    if(typeOperation==1)
					{this.price = quote.getBid();}
				    if(typeOperation==2)
				    {this.price = quote.getAsk();}	
					Logger.getLogger("file_log").log(Level.SEVERE, 	"Start ajax : Type operation = "+getTypeOperation());
			}
		}
	}
	public int getAjaxvalue(){
		return typeOperation;
	}


	public String buyOrder() {
//		boolean result = tradingOrderService.buyTradingOrder(tickerId, oz, sl, tp,
//				typeOrder, typeOperation, price, UserManageBean.getCurrentUser());
//		return String.valueOf(result);
        return null;
	}

}
