package com.enterprise.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enterprise.retail.entity.Store;
import com.enterprise.retail.repository.StoreRepository;

@Controller
@RequestMapping("/admin/stores")
public class AdminStoreController {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		List<Store> stores = storeRepository.findAll();
		uiModel.addAttribute("stores", stores);
		return "admin/stores/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Integer id, Model uiModel) {
		Store store = storeRepository.findOne(id);
		uiModel.addAttribute("store", store);
		return "admin/stores/show";
	}

	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("store", new Store());
		
		return "admin/stores/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Store store, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		storeValidator.validate(store, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("store", store);
			
			return "admin/stores/create";
		}
		
		store = storeRepository.save(store);
		
		return  "redirect:/admin/stores";
	}
}
