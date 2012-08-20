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
		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "This should not be empty!");
		// Check for uniqueness
		if(customerRepository.findByEmail(customer.getEmail()).size() > 0 && customer.isNew()) {
			errors.rejectValue("email", null, "Email already used!");
		}*/
	}
}
