package com.enterprise.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.retail.entity.Category;
import com.enterprise.retail.repository.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		List<Category> categories = categoryRepository.findAll();
		uiModel.addAttribute("categories", categories);
		return "admin/categories/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model uiModel) {
		Category category = categoryRepository.findOne(id);
		uiModel.addAttribute("category", category);
		return "admin/categories/show";
	}

	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("category", new Category());
		
		return "admin/categories/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Category category, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		categoryValidator.validate(category, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("category", category);
			
			return "admin/categories/create";
		}
		
		category = categoryRepository.save(category);
		
		return  "redirect:/admin/categories";
	}
}
