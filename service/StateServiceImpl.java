package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.State;
import com.emr.repository.StateRepository;
@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public State createState(State stareq) {
		// TODO Auto-generated method stub
		return stateRepository.save(stareq);
	}

	@Override
	public List<State> getState() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public State updateState(int id, State stareq) {
		// TODO Auto-generated method stub
		State sta = stateRepository.getById(id);
		sta.setId(stareq.getId());
		sta.setStateCode(stareq.getStateCode());
		sta.setCountry(stareq.getCountry());
		return stateRepository.save(stareq);
	}

	@Override
	public void deleteStateById(int id) {
		// TODO Auto-generated method stub
		stateRepository.deleteById(id);
	}

	@Override
	public Page<State> getStateByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return stateRepository.findAll(pageable);
	}

	@Override
	public List<State> getStateBySearch(String stateCode, Pageable pageable) {
		// TODO Auto-generated method stub
		return stateRepository.getStateBySearch(stateCode,pageable).getContent();
	}

}
