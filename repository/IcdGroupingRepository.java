package com.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.IcdGrouping;

@Repository
public interface IcdGroupingRepository extends JpaRepository<IcdGrouping, Integer>{

	 @Query(value="CALL icdGroupingShortDescription(:codesearch)",nativeQuery=true)
	List<IcdGrouping> icdGroupingShortDescription(String codesearch);

}
