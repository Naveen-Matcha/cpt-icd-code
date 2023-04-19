package com.emr.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

	// create query
	//@Query(value = "select * from allergy_new where id=:id and versionState='Validated'", nativeQuery = true)
	@Query("select a from Allergy a where a.damConceptId=:damConceptId and a.versionState='Validated'")
	Optional<Allergy> createAllergy(String damConceptId);
	// search query
	//@Query(value = "select * from allergy_new where AllergyDesc like %:searchcode% or DAM_CONCEPT_ID like %:searchcode% ", nativeQuery = true)
	@Query("select r from Allergy r where r.allergyDesc like %:searchcode% or r.damConceptId like %:searchcode%")
	public Page<Allergy> getAllergyPaginationSearch(String searchcode, Pageable pageable);

	// sorting search query
	//@Query(value = " select * from allergy_new where MATCH(allergy_desc,dam_concept_id_desc,dam_alrgn_grp_desc)AGAINST(:allergysearch)AND version_state='Validated'",nativeQuery = true)
   @Query("select m from Allergy m where m.allergyDesc like %:allergysearch% or m.damConceptId like %:allergysearch%")
	Page<Allergy> getAllergySearchSorting(String allergysearch, Pageable pageable);

	
	

}
