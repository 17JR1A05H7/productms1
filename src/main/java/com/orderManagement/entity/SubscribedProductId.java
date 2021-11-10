package com.orderManagement.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class SubscribedProductId implements Serializable{
	
	String buyerId;
	String productId;
	
	public SubscribedProductId() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	public SubscribedProductId(String buyerId, String productId) {
		super();
		this.buyerId = buyerId;
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(buyerId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscribedProductId other = (SubscribedProductId) obj;
		return Objects.equals(buyerId, other.buyerId) && Objects.equals(productId, other.productId);
	}
	
	
	
	
	
	

}
