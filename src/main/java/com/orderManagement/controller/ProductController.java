package com.orderManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Product;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService prodService;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value="/products")
	public List<Product> getAllProducts(){
		List<Product> p=prodService.getAllProducts();
		return p;
	}
	
	@GetMapping(value="/products/ByName/{productName}")
	public List<Product> getProductByName(@PathVariable String productName) throws InfyUserException{
		
		List<Product> p=prodService.getProductByName(productName);
		return p;
	}
	
	@GetMapping(value="/products/ByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) throws InfyUserException{
		
		List<Product> p=prodService.getProductByCategory(category);
		return p;
	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getProductDetails(@PathVariable String productId) throws InfyUserException{
		
		ProductDTO p=prodService.getProductDetails(productId);
		return p;
	}
	
	@PostMapping(value="/products/sellers/update/{stock}")
	public String UpdateStock(@PathVariable Integer stock,@RequestBody ProductDTO productId) {
		
		String s=prodService.updateStock(productId.getProductId(),stock);
		return s;
		
	}

	@PostMapping(value="/products/sellers/{sellerId}/add")
	public ResponseEntity<String> addProduct(@PathVariable String sellerId,@Valid @RequestBody ProductDTO productDTO) throws InfyUserException {
		try {
		String p=prodService.addProduct(sellerId,productDTO);
		return new ResponseEntity<>(p,HttpStatus.ACCEPTED);
	}
		catch(Exception e) {
			return new ResponseEntity<>(environment.getProperty(e.getMessage()),HttpStatus.UNAUTHORIZED);
		}
	}
	@DeleteMapping(value="/products/sellers/{sellerId}/delete/{productId}")
	public String deleteProduct(@PathVariable String sellerId,@PathVariable String productId ) {
		
		String p=prodService.removeProduct(productId);
		return p;
	}
	
	
	
	
	
	
	
	
	
}

