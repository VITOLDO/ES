package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the CURRENCY database table.
 * 
 */
@Entity
@Table(name="CURRENCY")
public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CURRENCY_ID")
	private Integer currencyId;

	private Byte code;

	private String name;

	@Column(name="SHORT_NAME")
	private String shortName;

    public Currency() {
    }

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Byte getCode() {
		return this.code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", code=" + code
				+ ", name=" + name + ", shortName=" + shortName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((shortName == null) ? 0 : shortName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Currency))
			return false;
		Currency other = (Currency) obj;
		if (this.getCurrencyId() != null)
			if (other.getCurrencyId() != null)
				if (this.getCurrencyId().intValue() == other.getCurrencyId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getCurrencyId(), other.getCurrencyId())
					.append(this.getCode(), other.getCode())
					.append(this.getName(), other.getName())
					.append(this.getShortName(), other.getShortName())
					.isEquals();
		}
		return false;
	}

}