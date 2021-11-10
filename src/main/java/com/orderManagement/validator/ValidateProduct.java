package com.orderManagement.validator;

import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.exception.InfyUserException;

public class ValidateProduct {

public static void validateProduct(ProductDTO product) throws InfyUserException {
		
		if(!validateName(product.getProductName()))
			throw new InfyUserException("Validator.VALIDATE_NAME");
		
		if(!validateDescription(product.getDescription()))
			throw new InfyUserException("Validator.VALIDATE_DESCRIPTION");
			
		if(!validatePrice(product.getPrice()))
			throw new InfyUserException("Validator.VALIDATE_PRICE");
		
		if(!validateStock(product.getStock()))
			throw new InfyUserException("Validator.VALIDATE_STOCK");
		
		if(!validateImage(product.getImage()))
			throw new InfyUserException("Validator.VALIDATE_IMAGE");
		
	}
	
	public static boolean validateName(String name)
	{
		String regex = "([A-Za-z]+([ ][A-Za-z]+)*){1,100}";
		
		if(name.matches(regex))
		{
			return true;
		}
		return false;
	}
	
	public static boolean validateDescription(String desc)
	{
		
		if(desc.length()>0 && desc.length()<=500 && desc!=null)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validatePrice(float price)
	{
		if(price >=200)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean validateStock(Integer stock)
	{
		if(stock>=10)
		{
			return true;
		}
		return false;
	}
	
	public static boolean validateImage(String image)
	{
		String regex = "[A-Za-z]+[\\.](png|jpeg)";
		
		if(image.matches(regex))
			return true;

		return false;
	}
}
