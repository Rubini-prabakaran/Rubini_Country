package com.cts.dao;
import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
 
	List<Country> findTopFiveCountry(float turnover);

	List<Country> findByID(int id);

	List<Country> findByCountryName(String name);

	Iterable<Country> findAll();
	public List<Country> findBypopulationBetween(Double startpopulation, Double endpopulation);
	
	List<Country> findByDateBetween(Date startDate, Date endDate);
}
