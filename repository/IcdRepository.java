package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Icd;

@Repository
public interface IcdRepository extends JpaRepository<Icd, Integer> {

	//@Query(value = "select * from icd10codes where Id=:icdCode and versionState='Valid'", nativeQuery = true)
	@Query("select m from Icd m where m.icdCode=:icdCode and m.versionState='Valid'")
	public Optional<Icd> createIcd(String icdCode);

	// pagination search query
	//@Query(value = "select * from icd10codes where ICDCode like %:icdcode% or ShortDesc like %:icdcode% ", nativeQuery = true)
	@Query("select r from Icd r where r.icdCode like %:icdcode% or r.shortDesc like %:icdcode%")
	public Slice<Icd> getIcdPaginationSearch(String icdcode, Pageable pageable);

	// pagination sorting query
	//@Query(value = " select * from icd10codes where ICDCode like %:icdcode% or ShortDesc like %:icdcode%", nativeQuery = true)
	@Query("select a from Icd a where a.icdCode like %:icdcode% or a.shortDesc like %:icdcode%")
	public Page<Icd> getIcdSearchSorting(String icdcode, Pageable pageable);

	@Query("select i from Icd i where i.versionState='Valid'")
	public List<Icd> findAllActiveRecords();

	

}
