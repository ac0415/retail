package com.enterprise.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.enterprise.retail.entity.Product;
import com.enterprise.retail.repository.ProductRepository;

@Component("ProductValidator")
public class ProductValidator implements Validator{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Product product = (Product)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productCode", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", null, "This should not be empty!");
		
		// Check for uniqueness
		if(productRepository.findByProductCode(product.getProductCode()).size() > 0 && product.isNew()) {
			errors.rejectValue("productCode", null, "Code already used!");
		}

		if(productRepository.findByProductName(product.getProductName()).size() > 0 && product.isNew()) {
			errors.rejectValue("productName", null, "Name already used!");
		}
	}
}
