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

import com.enterprise.retail.entity.Customer;
import com.enterprise.retail.repository.CustomerRepository;
import com.enterprise.retail.util.CustomerValidator;

@Controller
@RequestMapping("/admin/customers")
public class AdminCustomerController {

	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	private CustomerValidator customerValidator;

	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		
		List<Customer> customers = customerRepository.findAll();
		uiModel.addAttribute("customers", customers);
		
		return "admin/customers/index";
	}
	
	@RequestMapping(value="/{id}")
	public String show(@PathVariable("id") Integer id, Model uiModel) {
		
		Customer customer = customerRepository.findOne(id);
		uiModel.addAttribute("customer", customer);
		
		return "admin/customers/show";
	}
	
	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("customer", new Customer());
		
		return "admin/customers/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Customer customer, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		customerValidator.validate(customer, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("customer", customer);
			
			return "admin/customers/create";
		}
		
		customer = customerRepository.save(customer);
		
		return  "redirect:/admin/customers";
	}
}
