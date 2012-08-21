package com.enterprise.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.enterprise.retail.entity.Category;
import com.enterprise.retail.repository.CategoryRepository;

@Component("CategoryValidator")
public class CategoryValidator implements Validator{
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Category.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Category category = (Category)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryCode", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", null, "This should not be empty!");

		// Check for uniqueness
		if(categoryRepository.findByCategoryCode(category.getCategoryCode()).size() > 0 && category.isNew()) {
			errors.rejectValue("categoryCode", null, "Code already used!");
		}

		if(categoryRepository.findByCategoryName(category.getCategoryName()).size() > 0 && category.isNew()) {
			errors.rejectValue("categoryName", null, "Name already used!");
		}
	}
}
