package com.orderManagement.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Product;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.repository.ProductRepository;
import com.orderManagement.validator.ValidateProduct;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	static int index=101;
	
	public ProductDTO getProductDetails(String productId) throws InfyUserException {
		
		Product prod=productRepo.findById(productId).get();
		
		if(prod==null)
			throw new InfyUserException("Product Doesn't Exist");
		
		ProductDTO p=ProductDTO.valueOf(prod);
		
		return p;
	}
	
	public List<Product> getProductByCategory(String category) throws InfyUserException{
		
		List<Product> p=productRepo.findAllByCategory(category);
		
		if(p==null)
			throw new InfyUserException("Product doesn't exist with the given category");
		
		return p;
	}
	
	public List<Product> getProductByName(String name) throws InfyUserException{
		
		List<Product> p=productRepo.findAllByProductName(name);
		
		if(p==null)
			throw new InfyUserException("There's no product with the given name");
		
		return p;
	}
	
	public List<Product> getAllProducts(){
		
		List<Product> p=productRepo.findAll();
		
		return p;
	}
	
	public String addProduct(String sellerId,ProductDTO productDTO) throws InfyUserException {
		
		ValidateProduct.validateProduct(productDTO);
		
		try {
			
			String s="P"+ index++;
			Product product=new Product();
			product.setProductId(s);
			product.setProductName(productDTO.getProductName());
			product.setPrice(productDTO.getPrice());
			product.setCategory(productDTO.getCategory());
			product.setDescription(productDTO.getDescription());
			product.setImage(productDTO.getImage());
			product.setSubcategory(productDTO.getSubcategory());
			product.setSeller_id(sellerId);
			product.setProductRating(productDTO.getProductRating());
			product.setStock(productDTO.getStock());
			
			productRepo.save(product);
			return "Product Added Successfully";
		}
		catch(Exception e){
			return "Product couldn't be added.Bad request";
			
		}
	}
		
	public String removeProduct(String productId) {
		
		productRepo.deleteById(productId);
		
		return "Product Removed Successfully";
	}
	
	public String updateStock(String productId,Integer Stock) {
		
		Product p=productRepo.findById(productId).get();
		
		if(p.getStock()>=Stock)
		p.setStock(p.getStock()-Stock);
		
		productRepo.save(p);
		
		return "Updated Stock Successfully";
		
	}
	
}
