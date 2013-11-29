package com.epam.tradingsystem.broker.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;


/**
 * The persistent class for the OrderOperation database table.
 * 
 */
@Entity
@Table(name="ORDER_OPERATION")
public class OrderOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OREDER_OPERATION_ID")
	private Integer orderOperationId;

	

	
	private String name;

    public OrderOperation() {
    }

    public Integer getOrderOperationId() {
		return orderOperationId;
	}


	public void setOrderOperationId(Integer orderOperationId) {
		this.orderOperationId = orderOperationId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderOperation [orderOperationId=" + orderOperationId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderOperationId == null) ? 0 : orderOperationId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		OrderOperation other = (OrderOperation) obj;
		if (this.getOrderOperationId() != null)
			if (other.getOrderOperationId() != null)
				if (this.getOrderOperationId().intValue() == other.getOrderOperationId().intValue())
					return true;
		if (obj != null && this.getClass() == obj.getClass()) {
			return new EqualsBuilder()
					.append(this.getOrderOperationId(), other.getOrderOperationId())
					.append(this.getName(), other.getName()).isEquals();
		}
		return false;
	}

}