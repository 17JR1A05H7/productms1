package com.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.SubscribedProduct;
import com.orderManagement.entity.SubscribedProductId;

public interface SubscribedProductRepo extends JpaRepository <SubscribedProduct,SubscribedProductId>{

}
