package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Date;


/**
 * The persistent class for the RATE database table.
 * 
 */
@Entity
@Table(name="RATE")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RATE_ID")
	private Integer rateId;

	private BigDecimal close; 

	private BigDecimal high;

	private BigDecimal low;

	private BigDecimal open;

    @Temporal( TemporalType.TIMESTAMP)
	private Date time;

	//uni-directional many-to-one association to Ticker
    @ManyToOne
	@JoinColumn(name="TICKER_ID")
	private Ticker ticker;

    public Rate() {
    }

	public Integer getRateId() {
		return this.rateId;
	}

	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}

	public BigDecimal getClose() {
		return this.close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getHigh() {
		return this.high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getLow() {
		return this.low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getOpen() {
		return this.open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Ticker getTicker() {
		return this.ticker;
	}

	public void setTicker(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public String toString() {
		return "Rate [rateId=" + rateId + ", close=" + close + ", high=" + high
				+ ", low=" + low + ", open=" + open + ", time=" + time
				+ ", ticker=" + ticker + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((close == null) ? 0 : close.hashCode());
		result = prime * result + ((high == null) ? 0 : high.hashCode());
		result = prime * result + ((low == null) ? 0 : low.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + ((rateId == null) ? 0 : rateId.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Rate))
			return false;
		Rate other = (Rate) obj;
		if (this.getRateId() != null)
			if (other.getRateId() != null)
				if (this.getRateId().intValue() == other.getRateId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getRateId(), other.getRateId())
					.append(this.getClose(), other.getClose())
					.append(this.getHigh(), other.getHigh())
					.append(this.getLow(), other.getLow())
					.append(this.getOpen(), other.getOpen())
					.append(this.getTicker(), other.getTicker())
					.append(this.getTime(), other.getTime())
					.isEquals();
		}
		return false;
	}
	
}