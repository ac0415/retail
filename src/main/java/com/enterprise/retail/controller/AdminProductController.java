package com.enterprise.retail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enterprise.retail.entity.Product;
import com.enterprise.retail.repository.ProductRepository;
import com.enterprise.retail.util.ProductValidator;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductValidator productValidator;
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		List<Product> products = productRepository.findAll();
		uiModel.addAttribute("products", products);
		return "admin/products/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model uiModel) {
		Product product = productRepository.findOne(id);
		uiModel.addAttribute("product", product);
		return "admin/products/show";
	}

	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("product", new Product());
		
		return "admin/products/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Product product, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		productValidator.validate(product, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("product", product);
			
			return "admin/products/create";
		}
		
		product = productRepository.save(product);
		
		return  "redirect:/admin/customers";
	}
}
