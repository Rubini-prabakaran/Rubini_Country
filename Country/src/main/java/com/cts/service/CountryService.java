package com.cts.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.CountryRepository;
import com.cts.model.Country;


@Service
public class CountryService {
	@Autowired    
	private CountryRepository countryRepository;
	public List<Country> allCountry(){
		return (List<Country>) countryRepository.findAll();
	}
	
	public List<Country> topFiveCountry(){
		return (List<Country>) countryRepository.findTopFiveCountry(0);
	}
	
	public Country searchCountryById(int id){
		Optional<Country> s = countryRepository.findByID(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public static Country searchCountryByName(String name){
		Optional <Country> s =countryRepository.findByCountryName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Country> searchCountryBypopulation(Double startpopulation, Double endpopulation){
		return (List<Country>) countryRepository.findBypopulationBetween(startpopulation,endpopulation);
	}

	public List<Country> searchCountryByDate(Date startDate, Date endDate){
		return (List<Country>) countryRepository.findByDateBetween(startDate,endDate);
	}
}
