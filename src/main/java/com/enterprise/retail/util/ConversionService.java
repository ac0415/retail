package com.enterprise.retail.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import com.enterprise.retail.entity.Customer;
import com.enterprise.retail.entity.Category;
import com.enterprise.retail.entity.Product;
import com.enterprise.retail.entity.Store;
import com.enterprise.retail.entity.SaleTransaction;

import com.enterprise.retail.repository.CustomerRepository;
import com.enterprise.retail.repository.CategoryRepository;
import com.enterprise.retail.repository.StoreRepository;
import com.enterprise.retail.repository.ProductRepository;
import com.enterprise.retail.repository.SaleTransactionRepository;

@Component("conversionService")
public class ConversionService extends FormattingConversionServiceFactoryBean 
{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleTransactionRepository saleTransactionRepository;
	
	@Override
	public void installFormatters(FormatterRegistry registry) 
	{
		super.installFormatters(registry);
		registry.addConverter(getStringToCategoryConverter());
		registry.addConverter(getStringToCustomerConverter());
		registry.addConverter(getStringToProductConverter());
		registry.addConverter(getStringToStoreConverter());
		registry.addConverter(getStringToSaleTransactionConverter());
	}

	public Converter<String, Category> getStringToCategoryConverter()
	{
		return new Converter<String, Category>() {
			@Override
			public Category convert(String source) {
				return categoryRepository.findOne(Integer.parseInt(source));
			}
		};
	}
	
	public Converter<String, Customer> getStringToCustomerConverter()
	{
		return new Converter<String, Customer>() {
			@Override
			public Customer convert(String source) {
				return customerRepository.findOne(Integer.parseInt(source));
			}
		};
	}
	
	public Converter<String, Product> getStringToProductConverter()
	{
		return new Converter<String, Product>() {
			@Override
			public Product convert(String source) {
				return productRepository.findOne(Integer.parseInt(source));
			}
		};
	}
	
	public Converter<String, Store> getStringToStoreConverter()
	{
		return new Converter<String, Store>() {
			@Override
			public Store convert(String source) {
				return storeRepository.findOne(Integer.parseInt(source));
			}
		};
	}

	public Converter<String, SaleTransaction> getStringToSaleTransactionConverter()
	{
		return new Converter<String, SaleTransaction>() {
			@Override
			public SaleTransaction convert(String source) {
				return saleTransactionRepository.findOne(Integer.parseInt(source));
			}
		};
	}
}