package com.orderManagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.SubscribedProductDTO;
import com.orderManagement.entity.SubscribedProduct;
import com.orderManagement.entity.SubscribedProductId;
import com.orderManagement.repository.SubscribedProductRepo;

@Service
@Transactional
public class SubscribedProductService {
	
	@Autowired
	SubscribedProductRepo sprepo;
	
	public String addproduct(String buyerId,String productId,Integer quantity) {
		SubscribedProduct p=new SubscribedProduct();
		p.setSubscribedproduct(new SubscribedProductId(buyerId,productId));
		p.setQuantity(quantity);
		sprepo.save(p);
		return "Product Subscribed successfully";
		
	}
	

}
