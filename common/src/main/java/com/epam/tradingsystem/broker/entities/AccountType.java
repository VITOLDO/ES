package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the ACCOUNT_TYPE database table.
 * 
 */
@Entity
@Table(name="ACCOUNT_TYPE")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_TYPE_ID")
	private Integer accountTypeId;

	private String name;

    public AccountType() {
    }

	public Integer getAccountTypeId() {
		return this.accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountType [accountTypeId=" + accountTypeId + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountTypeId == null) ? 0 : accountTypeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountType))
			return false;
		AccountType other = (AccountType) obj;
		if (this.getAccountTypeId() != null)
			if (other.getAccountTypeId() != null)
				if (this.getAccountTypeId().intValue() == other.getAccountTypeId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getAccountTypeId(), other.getAccountTypeId())
					.append(this.getName(), other.getName())
					.isEquals();
		}
		return false;
	}

}