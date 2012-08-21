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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionCode", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionDate", null, "This should not be empty!");
		
		// Check for uniqueness
		if(saleTransactionRepository.findByTransactionCode(saleTransaction.getTransactionCode()).size() > 0 && saleTransaction.isNew()) {
			errors.rejectValue("transactionCode", null, "Code already used!");
		}
	}
}
