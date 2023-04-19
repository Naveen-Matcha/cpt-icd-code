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

import com.emr.model.Cpt;
import com.emr.model.CptCategory1;
import com.emr.service.CptService;


@RestController
public class CptController {

	@Autowired
	CptService cptService;

	@PostMapping("/cpt/add")
	public ResponseEntity<String> createCpt(@RequestBody Cpt cptReq) {
		Cpt cpt = cptService.createCpt(cptReq);
		return ResponseEntity.status(201).body("CPT Id is created" + cpt.getId());
	}

	@GetMapping("/cpt/list")
	public List<Cpt> getCpt() {
		return cptService.getCpt();

	}

	@GetMapping("/cpt/list/{id}")
	public Cpt getCptById(@PathVariable int id) {
		return cptService.getCptById(id);
	}

	@PutMapping("/cpt/edit/{id}")
	public ResponseEntity<String> updateCpt(@PathVariable int id, @RequestBody Cpt cptReq) {
		Cpt cpt = cptService.updateCpt(id, cptReq);
		return ResponseEntity.status(201).body("CPT Id is updated" + cpt.getId());

	}

	@DeleteMapping("/cpt/delete/{id}")
	public ResponseEntity<String> deleteCptById(@PathVariable int id) {
		cptService.deleteCptById(id);
		return ResponseEntity.status(201).body("CPT Id is deleted");
	}

	@GetMapping("/cpt/pagination")
	public ResponseEntity<Page<Cpt>> getCptPaginationById(@RequestParam(defaultValue = "20") Integer pageSize,
			@RequestParam(defaultValue = "0") Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Cpt> cpt = cptService.getCptPaginationById(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Page<Cpt>>(cpt, headers, HttpStatus.OK);
	}
	//cpt pagination without headers
	/*
	 * @GetMapping("/cpt/pagination") public Page<Cpt>
	 * getCptPaginationById(@RequestParam(defaultValue ="20") Integer pageSize,
	 * 
	 * @RequestParam(defaultValue = "0") Integer pageNumber){ Pageable pageable =
	 * PageRequest.of(pageNumber, pageSize); return
	 * cptService.getCptPaginationById(pageable); }
	 */

	//only pagination search with headers
	 /* @GetMapping("/cpt/pagination/search") 
	  public ResponseEntity<List<Cpt>> getCptSearchById(@RequestParam String shortName, @RequestParam Integer
	  pagesize,@RequestParam Integer PageNumber) { 
		  Pageable pageable = PageRequest.of(PageNumber, pagesize); 
		  HttpHeaders headers = new HttpHeaders(); 
		  List<Cpt> cpt = cptService.getCptSearchById(shortName, pageable);
		  return new ResponseEntity<List<Cpt>>(cpt, headers, HttpStatus.OK);
	  
	  }*/
	  
	 

	/*
	 * @GetMapping("/cpt/pagination/search") public List<Cpt>
	 * getCptSearchById(@RequestParam(defaultValue ="SALIVARY") String shortName,
	 * 
	 * @RequestParam(defaultValue ="20") Integer
	 * pageSize, @RequestParam(defaultValue = "0") Integer pageNumber ){ Pageable
	 * pageable = PageRequest.of(pageNumber, pageSize); return
	 * cptService.getCptSearchById(shortName,pageable);
	 * 
	 * }
	 */
	/*@GetMapping("/cptcategory/search")
	public ResponseEntity<List<CptCategory1>> getCptCategorySearchCodeOrDesc(@RequestParam String codeOrdesc,
			@RequestParam Integer pageSize, @RequestParam Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		List<CptCategory1> cptCategory = cptService.getCptCategorySearchCodeOrDesc(codeOrdesc, pageable);
		return new ResponseEntity<List<CptCategory1>>(cptCategory, headers, HttpStatus.OK);
	}*/
	
	@GetMapping("/cptcategory/search")
	public ResponseEntity <Page<CptCategory1>> getCptCategory1CodeOrShortName(@RequestParam String codeOrShortName,
			Pageable pageable){
		HttpHeaders headers = new HttpHeaders();
		Page<CptCategory1> cptCodeResponse = cptService.getCptCategory1CodeOrShortName(codeOrShortName, pageable);
		return new ResponseEntity<>(cptCodeResponse, headers, HttpStatus.OK);
	}
	//pagination sorting
	/*@GetMapping(path = "/paginationsorting")
	public ResponseEntity<List<Cpt>> getItemSorting(@RequestParam Integer pageSize,@RequestParam Integer pageNumber) {
	   List<Cpt> cpt = cptService.getCptSorting(pageNumber,pageSize);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Cpt>>(cpt, headers, HttpStatus.OK);
	}*/
	
	//pagination search sorting
	@GetMapping("/paginationsearchsorting")
	public Page<Cpt> getCptBycodeOrShortName(@RequestParam (value ="searchstring" )String codeOrShortName,@RequestParam(defaultValue = "50")Integer pageSize,
			@RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(value = "sortBy", required = false, defaultValue = "Newest First") String sortBy ){
		return cptService.getCptBycodeOrShortName(codeOrShortName,pageSize,pageNumber,sortBy);
	}

}
