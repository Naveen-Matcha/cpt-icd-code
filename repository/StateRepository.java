package com.emr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
    @Query(value = "select * from state where stateCode like %:stateCode%",nativeQuery=true )
    public Page<State> getStateBySearch(String stateCode, Pageable pageable);

}
