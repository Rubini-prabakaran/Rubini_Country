package com.cts.controller;

import java.util.Date;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Country;
import com.cts.service.CountryService;


@RestController
public class CountryController {
	@Autowired    
	private CountryService countryService;     
	
	
	@GetMapping(value = "/countryList")
	public ResponseEntity<Object> countryList()
	{
		
		return new ResponseEntity<>(countryService.allCountry(),HttpStatus.OK);
	}
	@GetMapping(value = "/getCountryById/id/{id}/name/{name}")
	public ResponseEntity<Object> personList(@PathVariable("id") Integer id)
	{
		
			Country country = countryService.searchCountryById(id);
			if(country!=null) {
				
				return new ResponseEntity<>(country,HttpStatus.OK);	
			}
			else
			return new ResponseEntity<>("Resord Not Found",HttpStatus.OK);
				
	}
	
	@GetMapping(value="/searchCountryByName/{name}")
	public ResponseEntity<?> searchCountryById(@PathVariable("name") String name)
	{
		Country s = CountryService.searchCountryByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(s,HttpStatus.OK);
	}
	@GetMapping(value="/searchCountryByPrice/{startpopulation}/{endpopulation}")
	public ResponseEntity<?> searchCountryByPrice(@PathVariable("startpopulation") Double startpopulation, @PathVariable("endpopulation") Double endpopulation )
	{
		List <Country> s = countryService.searchCountryBypopulation(startpopulation,endpopulation);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Country>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchCountryByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchCountryByDate(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List s = countryService.searchCountryByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveCountry")
	public ResponseEntity<?> topFiveCountry()
	{
		return new ResponseEntity List<Country>(countryService.topFiveCountry(),HttpStatus.OK);
	}

}
