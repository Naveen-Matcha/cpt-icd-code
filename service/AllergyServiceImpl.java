package com.emr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emr.model.Allergy;
import com.emr.repository.AllergyRepository;

@Service
public class AllergyServiceImpl implements AllergyService {

	@Autowired
	AllergyRepository allergyRepository;

	@Override
	public Allergy createAllergy(Allergy allergyRes) {
		// TODO Auto-generated method stub
		Optional<Allergy> allergyCode = allergyRepository.createAllergy(allergyRes.getDamConceptId());
		if (allergyCode.isPresent()) {
			return allergyCode.get();
		} else {
			Allergy allergy = allergyRepository.save(allergyRes);
			allergy.setRefId(allergy.getId());
			allergy.setOriginalRefId(allergy.getId());

		}
		return allergyRepository.save(allergyRes);
	}
	@Override
	public List<Allergy> getAllergy() {
		// TODO Auto-generated method stub
		return allergyRepository.findAll();
	}

	@Override
	public Allergy getAllergyId(int id) {
		// TODO Auto-generated method stub
		return allergyRepository.findById(id).get();
	}

	@Override
	public Page<Allergy> getAllergyPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return allergyRepository.findAll(pageable);
	}

	/*@Override
	public Page<Allergy> getAllergyPaginationSearch(String searchcode, Pageable pageable) {
		// TODO Auto-generated method stub
		return allergyRepository.getAllergyPaginationSearch(searchcode, pageable);
	}*/

	@Override
	public Page<Allergy> getAllergySearchSorting(String allergysearch, Integer pageNumber, Integer pageSize,
			String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable;
		if (sortBy.equals("Oldest First")) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
		} else {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		}
		return allergyRepository.getAllergySearchSorting(allergysearch, pageable);
	}

	@Override
	public Allergy updateAllergy(Allergy allergyRes) {
		// TODO Auto-generated method stub
		Optional<Allergy> allergyCode = allergyRepository.findById(allergyRes.getId());
		allergyCode.ifPresent(allergycode -> {
			allergycode.setVersionState("InValidated");
			allergycode.setRetired("Y");
			allergyRepository.save(allergycode);
			allergyRes.setRefId(allergycode.getId());
			allergyRes.setOriginalRefId(allergycode.getOriginalRefId());
			allergyRes.setVersionState("Validated");
			allergyRes.setRetired("N");
			allergyRes.setId(0);
			allergyRepository.save(allergyRes);
		});
		return allergyRes;
	}

}
