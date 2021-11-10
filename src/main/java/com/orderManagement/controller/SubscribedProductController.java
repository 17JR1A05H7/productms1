package com.orderManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderManagement.DTO.BuyerDTO;
import com.orderManagement.DTO.IsPrivileged;
import com.orderManagement.DTO.SubscribedProductDTO;
import com.orderManagement.service.SubscribedProductService;

@RestController
@CrossOrigin
public class SubscribedProductController {
	
	@Autowired
	SubscribedProductService spservice;
	
	@RequestMapping(value = "/subscribe/{buyerId}/{productId}/{quantity}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@PathVariable String buyerId,@PathVariable String productId,@PathVariable Integer quantity) {
		
		BuyerDTO b=new RestTemplate().getForObject("http://localhost:9100/buyer/"+buyerId, BuyerDTO.class);
		
		if(b.getIsPrivileged()==IsPrivileged.True) {
			String se=spservice.addproduct(buyerId,productId,quantity);
			return se;
		}
		else {
			return "Buyer needs to be privileged";
		}
	}
}
