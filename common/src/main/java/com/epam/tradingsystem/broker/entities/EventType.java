package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author Andriy Lapotko
 * The persistent class for the EVENT_TYPE database table.
 * 
 */
@Entity
@Table(name = "EVENT_TYPE")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_TYPE_ID")
	private int eventTypeId;

	private String description;

	private String name;

	public EventType() {
	}

	public int getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EventType [eventTypeId=" + eventTypeId + ", description="
				+ description + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EventType other = (EventType) obj;
				if (eventTypeId == other.getEventTypeId())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getDescription(), other.getDescription())
					.append(this.getName(), other.getName())
					.isEquals();
		}
		return false;
	}
}