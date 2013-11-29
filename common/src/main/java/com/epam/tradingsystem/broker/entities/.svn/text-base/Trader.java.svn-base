package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the USER database table.
 * 
 */
@Entity
@Table(name="TRADER")
public class Trader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;

    @Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String login;

	private String password;

	//uni-directional many-to-one association to Country
    @ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

    /*
     * @author Filonenko
     * 
     * @return List of accounts referenced to user
     */
    @OneToMany(mappedBy = "trader", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> account = new LinkedList<Account>();
    
    public Trader() {
    }

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", birthDate=" + birthDate
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", login=" + login + ", password=" + password + ", country="
				+ country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Trader))
			return false;
		Trader other = (Trader) obj;
		if (this.getUserId() != null)
			if (other.getUserId() != null)
				if (this.getUserId().intValue() == other.getUserId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getUserId(), other.getUserId())
					.append(this.getBirthDate(), other.getBirthDate())
					.append(this.getCountry(), other.getCountry())
					.append(this.getFirstName(), other.getFirstName())
					.append(this.getLastName(), other.getLastName())
					.append(this.getLogin(), other.getLogin())
					.append(this.getPassword(), other.getPassword())
					.isEquals();
		}
		return false;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
}