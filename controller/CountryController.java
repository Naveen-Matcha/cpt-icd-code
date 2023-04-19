package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Country;
import com.emr.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	@PostMapping("/country/add")
	public ResponseEntity<String> createCountry(@RequestBody Country counreq) {
		Country country = countryService.createCountry(counreq);
		return ResponseEntity.status(201).body("id is created" + country.getCid());
	}

	@GetMapping("/country/list")
	public List<Country> getCountry() {
		return countryService.getCountry();
	}

	@PutMapping("/country/edit/{id}")
	public ResponseEntity<String> updateCountry(@PathVariable int id, @RequestBody Country counreq) {
		Country country = countryService.updateCountry(id, counreq);
		return ResponseEntity.status(201).body("id is updated" + country.getCid());
	}

	@DeleteMapping("/country/delete/{id}")
	public ResponseEntity<String> deleteCountryById(@PathVariable int id) {
		countryService.deleteCountryById(id);
		return ResponseEntity.status(201).body("id is deleted");
	}

	@GetMapping("/country/pagination")
	public ResponseEntity<List<Country>> getCountryByPagination(@RequestParam Integer pageSize,

			@RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Country> country = countryService.getAllCountryByPagination(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Country>>(country.getContent(), headers, HttpStatus.OK);
	}
	
	
	  @GetMapping("/country/search")
	  public ResponseEntity<List<Country>> getCountryBySearch(@RequestParam String countryName,@RequestParam Integer pageSize , @RequestParam Integer pageNumber){
		  Pageable pageable = PageRequest.of(pageNumber, pageSize); 
		  HttpHeaders headers = new HttpHeaders(); 
		  List<Country> countryResponse = countryService.getAllCountryBySearch(countryName,pageable);
	  
	  return new ResponseEntity<>(countryResponse,headers ,HttpStatus.OK); 
	  }
	 
	
	 

	/*
	 * @GetMapping("/country/pagination") public ResponseEntity<List<Country>>
	 * getCountryByPagination(@RequestParam Integer pageSize,
	 * 
	 * @RequestParam Integer pageNumber) { Pageable pageable =
	 * PageRequest.of(pageNumber, pageSize); Page<Country> country =
	 * countryService.getAllCountryByPagination(pageable); HttpHeaders headers = new
	 * HttpHeaders(); return new ResponseEntity<List<Country>>(country.getContent(),
	 * headers, HttpStatus.OK); }
	 */

}
