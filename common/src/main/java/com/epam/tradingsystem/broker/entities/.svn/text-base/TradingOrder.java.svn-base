package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the TRADING_ORDER database table.
 * 
 */
@Entity
@Table(name="TRADING_ORDER")
public class TradingOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRADING_ORDER_ID")
	private Integer tradingOrderId;

	private BigDecimal commission;

    @Temporal( TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="ORDER_NO")
	private Integer orderNo;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name="OREDER_OPERATION_ID")
	private OrderOperation orderOperation;
	//private String type;

   
	@Temporal( TemporalType.TIMESTAMP)
	private Date valid;

	private Float volume;

	//uni-directional many-to-one association to Account
    @ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
    
	//uni-directional many-to-one association to Ticker
    @ManyToOne
	@JoinColumn(name="TICKER_ID")
	private Ticker ticker;

    public TradingOrder() {
    }

	public Integer getTradingOrderId() {
		return this.tradingOrderId;
	}

	public void setTradingOrderId(Integer tradingOrderId) {
		this.tradingOrderId = tradingOrderId;
	}

	public BigDecimal getCommission() {
		return this.commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public Date getCreated() {
		return this.created;
	}

	 public OrderOperation getOrderOperation() {
			return orderOperation;
		}

		public void setOrderOperation(OrderOperation orderOperation) {
			this.orderOperation = orderOperation;
		}

		
	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

//	public String getType() {
//		return this.type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public Date getValid() {
		return this.valid;
	}

	public void setValid(Date valid) {
		this.valid = valid;
	}

	public float getVolume() {
		return this.volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Ticker getTicker() {
		return this.ticker;
	}

	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "TradingOrder [tradingOrderId=" + tradingOrderId
				+ ", commission=" + commission + ", created=" + created
				+ ", orderNo=" + orderNo + ", price=" + price + ", orderOperation="
				+ orderOperation + ", valid=" + valid + ", volume=" + volume
				+ ", account=" + account + ", ticker=" + ticker + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result
				+ ((commission == null) ? 0 : commission.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		result = prime * result
				+ ((tradingOrderId == null) ? 0 : tradingOrderId.hashCode());
		result = prime * result + ((orderOperation == null) ? 0 : orderOperation.hashCode());
		result = prime * result + ((valid == null) ? 0 : valid.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TradingOrder))
			return false;
		TradingOrder other = (TradingOrder) obj;
		if (this.getTradingOrderId() != null)
			if (other.getTradingOrderId() != null)
				if (this.getTradingOrderId().intValue() == other.getTradingOrderId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getTradingOrderId(), other.getTradingOrderId())
					.append(this.getAccount(), other.getAccount())
					.append(this.getCommission(), other.getCommission())
					.append(this.getCreated(), other.getCreated())
					.append(this.getOrderNo(), other.getOrderNo())
					.append(this.getPrice(), other.getPrice())
					.append(this.getTicker(), other.getTicker())
					.append(this.getOrderOperation(), other.getOrderOperation())
					.append(this.getValid(), other.getValid())
					.append(this.getVolume(), other.getVolume())
					.isEquals();
		}
		return false;
	}
	
}