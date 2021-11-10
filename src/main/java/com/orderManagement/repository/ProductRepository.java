package com.orderManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product,String> {
	
	public List<Product> findAllByCategory(String category);
    public List<Product> findAllByProductName(String name);

}
