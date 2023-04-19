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

import com.emr.model.State;
import com.emr.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@PostMapping("/state/add")
	public ResponseEntity<String> createState(@RequestBody State stareq){
		State state = stateService.createState(stareq);
		return ResponseEntity.status(201).body("id is created"+state.getId());
		
	}
	@GetMapping("/state/list")
	public List<State> getState(){
		return stateService.getState();
	}
	@PutMapping("/state/edit/{id}")
	public ResponseEntity<String> updateState(@PathVariable int id, @RequestBody State stareq){
		State state =stateService. updateState(id,stareq);
		return ResponseEntity.status(201).body("id is updated"+state.getId());
	}
	@DeleteMapping("/state/delete/{id}")
	public ResponseEntity<String> deleteStateById(@PathVariable int id){
		stateService.deleteStateById(id);
		return ResponseEntity.status(201).body("id is deleted");
	}
	@GetMapping("/state/pagination")
	public ResponseEntity<List<State>> getStateByPagination(@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<State> state = stateService.getStateByPagination(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<State>>(state.getContent(), headers ,HttpStatus.OK);
	}
	@GetMapping("/state/search")
	public ResponseEntity<List<State>> getStateBySearch(@RequestParam String stateCode, @RequestParam Integer pageSize,@RequestParam Integer pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		HttpHeaders headers = new HttpHeaders();
		 List<State> state = stateService.getStateBySearch(stateCode,pageable);
		 return new ResponseEntity<List<State>>(state,headers,HttpStatus.OK);
	}
	

}
