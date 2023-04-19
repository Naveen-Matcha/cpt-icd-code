package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.Icd;
import com.emr.model.IcdGrouping;

@Service
public interface IcdService {

	Icd createIcd(Icd icdReq);

	List<Icd> getIcd();

	Icd getIcdCode(int id);

	Icd updateIcd(Icd icdReq);

	void deleteIcd(int id);

	Page<Icd> getIcdPagination(Pageable pageable);

	//List<Icd> getIcdPaginationSearch(String icdcode, Pageable pageable);

	Page<Icd> getIcdSearchSorting(String icdcode, Integer pageNumber, Integer pageSize, String sortBy);

	Page<IcdGrouping> icdGroupingShortDescription(String codesearch, Pageable pageable);

	//Icd deleteIcd(String code);

	

}
