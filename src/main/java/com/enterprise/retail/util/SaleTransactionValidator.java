package com.enterprise.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.enterprise.retail.entity.SaleTransaction;
import com.enterprise.retail.repository.SaleTransactionRepository;

@Component("SaleTransactionValidator")
public class SaleTransactionValidator implements Validator{
	@Autowired
	SaleTransactionRepository saleTransactionRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return SaleTransaction.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		SaleTransaction saleTransaction = (SaleTransaction)target;
		
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
