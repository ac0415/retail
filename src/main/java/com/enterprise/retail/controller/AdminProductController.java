package com.enterprise.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.retail.entity.Product;
import com.enterprise.retail.repository.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
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
}
