package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.Allergy;

@Service
public interface AllergyService {

	Allergy createAllergy(Allergy allergyRes);

	List<Allergy> getAllergy();

	Allergy getAllergyId(int id);

	Page<Allergy> getAllergyPagination(Pageable pageable);

	//Page<Allergy> getAllergyPaginationSearch(String searchcode, Pageable pageable);

	Page<Allergy> getAllergySearchSorting(String allergysearch, Integer pageNumber, Integer pageSize, String sortBy);

	Allergy updateAllergy(Allergy allergyRes);

}
