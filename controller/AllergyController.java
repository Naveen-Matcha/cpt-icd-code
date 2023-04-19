package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Allergy;
import com.emr.service.AllergyService;

@RestController
public class AllergyController {

	@Autowired
	AllergyService allergyService;

	@PostMapping("/allergy/add")
	public ResponseEntity<Allergy> createAllergy(@RequestBody Allergy allergyRes) {
		Allergy allergy = allergyService.createAllergy(allergyRes);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Allergy>(allergy, headers, HttpStatus.CREATED);
	}

	@GetMapping("/allergy/list")
	public ResponseEntity<List<Allergy>> getAllergy() {
		List<Allergy> allergy = allergyService.getAllergy();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Allergy>>(allergy, headers, HttpStatus.OK);
	}

	@GetMapping("/allergy/list/{id}")
	public ResponseEntity<Allergy> getAllergyId(@PathVariable int id) {
		Allergy allergy = allergyService.getAllergyId(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Allergy>(allergy, headers, HttpStatus.OK);
	}

	@GetMapping("/allergy/pagination")
	public ResponseEntity<Page<Allergy>> getAllergyPagination(@RequestParam(defaultValue = "20") Integer pageSize,
			@RequestParam(defaultValue = "0") Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		Page<Allergy> allergy = allergyService.getAllergyPagination(pageable);
		return new ResponseEntity<Page<Allergy>>(allergy, headers, HttpStatus.OK);
	}

	/*@GetMapping("/allergy/pagination/search")
	public ResponseEntity<Page<Allergy>> getAllergyPaginationSearch(@RequestParam String searchcode,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Allergy> allergy = allergyService.getAllergyPaginationSearch(searchcode, pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Page<Allergy>>(allergy, headers, HttpStatus.OK);
	}*/

	@GetMapping("/allergy/pagination/searchsorting")
	public Page<Allergy> getAllergySearchSorting(@RequestParam String allergysearch, @RequestParam Integer pageSize,
			@RequestParam Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "Newest First") String sortBy) {
		return allergyService.getAllergySearchSorting(allergysearch, pageNumber, pageSize, sortBy);
	}

	@PutMapping("/allergy/edit/{id}")
	public ResponseEntity<Allergy> updateAllergy(@RequestBody Allergy allergyRes) {
		Allergy allergy = allergyService.updateAllergy(allergyRes);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Allergy>(allergy, headers, HttpStatus.OK);

	}

}
