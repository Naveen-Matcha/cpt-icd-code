package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.Cpt;
import com.emr.model.CptCategory1;

@Repository
public interface CptRepository extends JpaRepository<Cpt, Integer> {
	
	//pagination search
    //@Query(value = "select * from cpt_short where shortName like %:shortName% or Code like %:shortName% or Description like %:shortName%",nativeQuery=true)
    @Query("select a from Cpt a where a.shortName like %:shortName% or a.code like %:shortName% or a.description like %:shortName%")
	public Page<Cpt> getCptSearchById(String shortName, Pageable pageable);
    
   // @Query(value = "select * from cpt_short where Code=:code and versionState='Valid'",nativeQuery=true)
    @Query("select m from Cpt m where m.code=:code and versionState='Valid'")
	public Optional<Cpt> getCptByVersionState(String code);
    
    //for  valid records 
    //@Query(value = "select * from cpt_short where versionState='Valid'",nativeQuery=true)
    @Query("select e from Cpt e where e.versionState='Valid'")
	public List<Cpt> findActiveAll();
    
    //for Invalid records
    //@Query(value = "select * from cpt_short where versionState='InValid'",nativeQuery=true)
    @Query("select e from Cpt e where e.versionState='InValid'")
	public List<Cpt> findInActiveAll();
    
    //@Query(value = " select * from cpt_short where ShortName like %:codeOrShortName% or Code like %:codeOrShortName% ", nativeQuery = true)
    @Query("select t from Cpt t where t.shortName like %:codeOrShortName% or t.code like %:codeOrShortName%")
	public Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Pageable pageable);
    
   
	
    //select i from Icd i where i.versionState='Valid

}
