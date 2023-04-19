package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.State;
@Service
public interface StateService {

	State createState(State stareq);

	List<State> getState();

	State updateState(int id, State stareq);

	void deleteStateById(int id);

	Page<State> getStateByPagination(Pageable pageable);

	List<State> getStateBySearch(String stateCode, Pageable pageable);

	

}
