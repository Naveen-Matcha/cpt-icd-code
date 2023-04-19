package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.Cpt;
import com.emr.model.CptCategory1;

@Service
public interface CptService {

	Cpt createCpt(Cpt cptReq);

	List<Cpt> getCpt();

	Cpt updateCpt(int id, Cpt cptReq);

	void deleteCptById(int id);

	Cpt getCptById(int id);

	Page<Cpt> getCptPaginationById(Pageable pageable);

	//List<Cpt> getCptSearchById(String shortName, Pageable pageable);

	//List<CptCategory1> getCptCategorySearchCodeOrDesc(String codeOrdesc, Pageable pageable);
	
	
    //Without headers in cptcategory in search
	
	Page<CptCategory1> getCptCategory1CodeOrShortName(String codeOrShortName, Pageable pageable);
	

	//List<Cpt> getCptSorting(Integer pageNumber, Integer pageSize);

	Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Integer pageSize, Integer pageNumber, String sortBy);

	

	

	


	
	

	
	

}
