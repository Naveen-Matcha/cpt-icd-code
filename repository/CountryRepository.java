package com.emr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	@Query(value="select * from country where countryName like %:countryName%",nativeQuery=true)
	public Page<Country> getAllCountryBySearch(String countryName, Pageable pageable);
	
	
	
	
	
	
	//@Query(value = "select * from database_practice.country where countryName like %:countryName%")
	//Page<Country> getAllCountryBySearch(String countryName, Pageable pageable);

	// @Query(value="select * from database_practice.country where countryName like
	// %:countryName%")

}

// Slice<Country> getCountryBycountryName(String countryName, Pageable
// pageable);

// @Query(value="select * from country where countryName like %:countryName%")
// Object getAllCountryBySearch(String countryName, Pageable pageable);
