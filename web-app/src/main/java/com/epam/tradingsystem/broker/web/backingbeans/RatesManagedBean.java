package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.rate.quotes.Quote;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
@Controller
public class RatesManagedBean {
	
//	@Autowired
//	private RateEJBLocal rateBean;

	public RatesManagedBean() {

	}
	
	public List<Quote> getRatesView() {
//		return rateBean.getLastQuotes();
        return Collections.EMPTY_LIST;
	}
	
}