package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the USERGROUP database table.
 * 
 */
@Entity
@Table(name="USERGROUP")
public class Usergroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERGROUP_ID")
	private Integer usergroupId;

	private String name;

	private String login;
	
    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Usergroup() {
    }

	public Integer getUsergroupId() {
		return this.usergroupId;
	}

	public void setUsergroupId(Integer usergroupId) {
		this.usergroupId = usergroupId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Usergroup [usergroupId=" + usergroupId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((usergroupId == null) ? 0 : usergroupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usergroup))
			return false;
		Usergroup other = (Usergroup) obj;
		if (this.getUsergroupId() != null)
			if (other.getUsergroupId() != null)
				if (this.getUsergroupId().intValue() == other.getUsergroupId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getUsergroupId(), other.getUsergroupId())
					.append(this.getName(), other.getName())
					.isEquals();
		}
		return false;
	}

}