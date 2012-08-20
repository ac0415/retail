package com.enterprise.retail.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import com.enterprise.retail.entity.Customer;
//import com.enterprise.retail.entity.Sector;
//import com.enterprise.retail.entity.Site;
//import com.enterprise.retail.entity.Vehicle;

import com.enterprise.retail.repository.CustomerRepository;
//import com.enterprise.retail.repository.SectorRepository;
//import com.enterprise.retail.repository.SiteRepository;
//import com.enterprise.retail.repository.VehicleRepository;

@Component("conversionService")
public class ConversionService extends FormattingConversionServiceFactoryBean 
{
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	private SiteRepository siteRepository;
//	
//	@Autowired
//	private VehicleRepository vehicleRepository;
//	
//	@Autowired
//	private SectorRepository sectorRepository;
//	
//	@Override
//	public void installFormatters(FormatterRegistry registry) 
//	{
//		super.installFormatters(registry);
//		registry.addConverter(getStringToCrewConverter());
//		registry.addConverter(getStringToDateConverter());
//		registry.addConverter(getStringToSiteConverter());
//		registry.addConverter(getStringToVehicleConverter());
//		registry.addConverter(getStringToSectorConverter());
//	}
//	
//	public Converter<String, Date> getStringToDateConverter()
//	{
//		return new Converter<String, Date>() {
//			@Override
//			public Date convert(String source) {
//				return new Date();
//			}
//		};
//	}
//	
//	public Converter<String, Sector> getStringToSectorConverter()
//	{
//		return new Converter<String, Sector>() {
//			@Override
//			public Sector convert(String source) {
//				return sectorRepository.findOne(Long.parseLong(source));
//			}
//		};
//	}
//	
	public Converter<String, Customer> getStringToCustomerConverter()
	{
		return new Converter<String, Customer>() {
			@Override
			public Customer convert(String source) {
				return customerRepository.findOne(Integer.parseInt(source));
			}
		};
	}
//	
//	public Converter<String, Site> getStringToSiteConverter()
//	{
//		return new Converter<String, Site>() {
//			@Override
//			public Site convert(String source) {
//				return siteRepository.findOne(Long.parseLong(source));
//			}
//		};
//	}
//	
//	public Converter<String, Vehicle> getStringToVehicleConverter()
//	{
//		return new Converter<String, Vehicle>() {
//			@Override
//			public Vehicle convert(String source) {
//				return vehicleRepository.findOne(Long.parseLong(source));
//			}
//		};
//	}
}