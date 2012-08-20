package com.enterprise.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.retail.entity.SaleTransaction;
import com.enterprise.retail.repository.SaleTransactionRepository;

@Controller
@RequestMapping("/admin/saletransactions")
public class AdminSaleTransactionController {
	
	@Autowired
	private SaleTransactionRepository saleTransactionRepository;
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		List<SaleTransaction> saleTransactions = saleTransactionRepository.findAll();
		uiModel.addAttribute("saleTransactions", saleTransactions);
		return "admin/saletransactions/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model uiModel) {
		SaleTransaction saleTransaction = saleTransactionRepository.findOne(id);
		uiModel.addAttribute("saleTransaction", saleTransaction);
		return "admin/saletransactions/show";
	}

	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("saleTransaction", new SaleTransaction());
		
		return "admin/saleTransactions/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(SaleTransaction saleTransaction, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		saleTransactionValidator.validate(saleTransaction, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("saleTransaction", saleTransaction);
			
			return "admin/saleTransactions/create";
		}
		
		saleTransaction = saleTransactionRepository.save(saleTransaction);
		
		return  "redirect:/admin/customers";
	}
}
