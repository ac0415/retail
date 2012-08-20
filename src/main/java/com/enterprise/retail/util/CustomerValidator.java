package com.enterprise.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.enterprise.retail.entity.Customer;
import com.enterprise.retail.repository.CustomerRepository;

@Component("CustomerValidator")
public class CustomerValidator implements Validator{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Customer customer = (Customer)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "This should not be empty!");
		// Check for uniqueness
		if(customerRepository.findByEmail(customer.getEmail()).size() > 0 && customer.isNew()) {
			errors.rejectValue("email", null, "Email already used!");
		}
	}
}
