package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Date;

/**
 *  @author Andriy Lapotko
 * The persistent class for the EVENT database table.
 * 
 */
@Entity
@Table(name = "EVENT")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_ID")
	private int eventId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String message;

	// uni-directional many-to-one association to EventType
	@ManyToOne
	@JoinColumn(name = "EVENT_TYPE_ID")
	private EventType eventType;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Trader trader;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EventType getEventType() {
		return this.eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", date=" + date + ", message="
				+ message + ", eventType=" + eventType + ", trader=" + trader
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((trader == null) ? 0 : trader.hashCode());
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
		Event other = (Event) obj;
		if (eventId == other.getEventId())
			return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder().append(this.getDate(), other.getDate())
					.append(this.getEventType(), other.getEventType())
					.append(this.getMessage(), other.getMessage())
					.append(this.getTrader(), other.getTrader())
					.isEquals();
		}
		return false;
	}

}