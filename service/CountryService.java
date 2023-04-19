package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.Country;
@Service
public interface CountryService {

	Country createCountry(Country counreq);

	List<Country> getCountry();

	Country updateCountry(int id, Country counreq);

	void deleteCountryById(int id);

	Page<Country> getAllCountryByPagination(Pageable pageable);

	List<Country> getAllCountryBySearch(String countryName, Pageable pageable);

	//List<Country> getAllCountryBySearch(String countryName, Pageable pageable);

	//List<Country> getAllCountryBySearch(String countryName, Pageable pageable);

	

	

	
	
	

	

	//Page<Country> getAllCountryBySearch(String countryName, Pageable pageable);

	

}
