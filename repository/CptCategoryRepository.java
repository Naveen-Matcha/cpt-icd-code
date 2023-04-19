package com.emr.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.CptCategory1;

@Repository
public interface CptCategoryRepository extends JpaRepository<CptCategory1, Integer> {
    
	
    @Query(value="CALL getCptCategory1CodeOrShortName(:codeOrShortName)",nativeQuery=true)
	List<CptCategory1> getCptCategory1CodeOrShortName(String codeOrShortName);
    
	
   
   
	
	
    
}
