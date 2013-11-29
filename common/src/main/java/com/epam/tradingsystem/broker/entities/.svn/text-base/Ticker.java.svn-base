package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * The persistent class for the TICKER database table.
 * 
 */
@Entity
@Table(name="TICKER")
public class Ticker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TICKER_ID")
	private Integer tickerId;

	private String name;

	// uni-directional many-to-one association to Currency
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "CURRENCY_ID"),
			@JoinColumn(name = "CUR_CURRENCY_ID", referencedColumnName = "CURRENCY_ID") 
			})
	private Currency currency;

	public Ticker() {
	}

	public Integer getTickerId() {
		return this.tickerId;
	}

	public void setTickerId(Integer tickerId) {
		this.tickerId = tickerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Ticker [tickerId=" + tickerId + ", name=" + name
				+ ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((tickerId == null) ? 0 : tickerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ticker))
			return false;
		Ticker other = (Ticker) obj;
		if (this.getTickerId() != null)
			if (other.getTickerId() != null)
				if (this.getTickerId().intValue() == other.getTickerId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getTickerId(), other.getTickerId())
					.append(this.getCurrency(), other.getCurrency())
					.append(this.getName(), other.getName())
					.isEquals();
		}
		return false;
	}

}