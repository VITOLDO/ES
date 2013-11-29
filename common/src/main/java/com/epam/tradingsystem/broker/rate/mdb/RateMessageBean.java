package com.epam.tradingsystem.broker.rate.mdb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.epam.tradingsystem.broker.exchange.quotes.csv.CSVParser;
import com.epam.tradingsystem.broker.exchange.quotes.csv.CSVSeparator;
import com.epam.tradingsystem.broker.exchange.quotes.csv.SeparatorType;
import com.epam.tradingsystem.broker.rate.quotes.Quote;
import com.epam.tradingsystem.broker.rate.quotes.QuoteBuilder;
import com.epam.tradingsystem.broker.rate.quotes.RatesView;


/**
 * Message-Driven Bean implementation class for: RateMessageBean
 *
 */
@MessageDriven(mappedName="jms/RatesTopic")
public class RateMessageBean implements MessageListener {
	private Logger logger = Logger.getLogger("file_log");
	RatesView rv = RatesView.getInstance();

    /**
     * Default constructor.
     */
    public RateMessageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
		TextMessage msg = null;
		try {
			if (message instanceof TextMessage) {
				msg = (TextMessage) message;
				String messageText = msg.getText();
				
				ArrayList<String> quotesStringList = 
					CSVParser.parse(messageText, new CSVSeparator(SeparatorType.DOTCOMA));
				
				List<Quote> quotes = new ArrayList<Quote>();
				for (String s:quotesStringList) {
					quotes.add(QuoteBuilder.build(s));
				}
				rv.setRates(quotes);
			} else {
				logger.log(Level.SEVERE, "Read message: " + message.getClass().getName());
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Broker: Exception in onMessage(): " + e.getMessage(), e);
		}
    }
}
