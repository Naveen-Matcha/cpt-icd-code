package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.Country;
import com.emr.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country createCountry(Country counreq) {
		// TODO Auto-generated method stub
		return countryRepository.save(counreq);
	}

	@Override
	public List<Country> getCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Country updateCountry(int id, Country counreq) {
		// TODO Auto-generated method stub
		Country cou = countryRepository.getById(id);
		cou.setCid(counreq.getCid());
		cou.setCountryName(counreq.getCountryName());
		return countryRepository.save(counreq);
	}

	@Override
	public void deleteCountryById(int id) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(id);
	}

	@Override
	public Page<Country> getAllCountryByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return countryRepository.findAll(pageable);
	}

	@Override
	public List<Country> getAllCountryBySearch(String countryName, Pageable pageable) {
		// TODO Auto-generated method stub
		return countryRepository.getAllCountryBySearch(countryName,pageable).getContent();
	}

	
	
	

	
	
	
	
	
	
	
	

}
