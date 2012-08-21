package com.enterprise.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.enterprise.retail.entity.Store;
import com.enterprise.retail.repository.StoreRepository;

@Component("StoreValidator")
public class StoreValidator implements Validator{
	@Autowired
	StoreRepository storeRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Store.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Store store = (Store)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeCode", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "This should not be empty!");
		
		// Check for uniqueness
		if(storeRepository.findByStoreCode(store.getStoreCode()).size() > 0 && store.isNew()) {
			errors.rejectValue("storeCode", null, "Code already used!");
		}

		if(storeRepository.findByStoreName(store.getStoreName()).size() > 0 && store.isNew()) {
			errors.rejectValue("storeName", null, "Name already used!");
		}
	}
}
