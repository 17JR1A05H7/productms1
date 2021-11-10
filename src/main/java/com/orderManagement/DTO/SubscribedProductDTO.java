package com.orderManagement.DTO;

import com.orderManagement.entity.SubscribedProduct;

public class SubscribedProductDTO {
	
	String buyerId;
	
	String productId;
	
	Integer quantity;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public SubscribedProductDTO(String buyerId, String productId, Integer quantity) {
		super();
		this.buyerId = buyerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public SubscribedProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public static SubscribedProductDTO valueOf(SubscribedProduct s) {
		SubscribedProductDTO spd=new SubscribedProductDTO();
		spd.setBuyerId(s.getSubscribedproduct().getBuyerId());
		spd.setProductId(s.getSubscribedproduct().getProductId());
		spd.setQuantity(s.getQuantity());
		return spd;
	}
	

}
