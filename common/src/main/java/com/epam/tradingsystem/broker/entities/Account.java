package com.epam.tradingsystem.broker.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.*;
import java.io.Serializable;



/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ACCOUNT_ID")
	private Integer accountId;

	private Double deposit;

	private Integer num;

	//uni-directional many-to-one association to AccountType
    @ManyToOne
	@JoinColumn(name="ACCOUNT_TYPE_ID")
	private AccountType accountType;

	//uni-directional many-to-one association to Currency
    @ManyToOne
	@JoinColumn(name="CURRENCY_ID")
	private Currency currency;

	//uni-directional many-to-one association to Trader
    @ManyToOne
	@JoinColumn(name="USER_ID")
	private Trader trader;

    public Account() {
    }

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Trader getTrader() {
		return this.trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", deposit=" + deposit
				+ ", num=" + num + ", accountType=" + accountType
				+ ", currency=" + currency + ", trader=" + trader + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((trader == null) ? 0 : trader.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (this.getAccountId() != null)
			if (other.getAccountId() != null)
				if (this.getAccountId().intValue() == other.getAccountId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getAccountId(), other.getAccountId())
					.append(this.getAccountType(), other.getAccountType())
					.append(this.getCurrency(), other.getCurrency())
					.append(this.getDeposit(), other.getDeposit())
					.append(this.getNum(), other.getNum())
					.append(this.getTrader(), other.getTrader())
					.isEquals();
		}
		return false;
	}
	
}