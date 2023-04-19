package com.emr.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;


import com.emr.model.Icd;
import com.emr.model.IcdGrouping;
import com.emr.repository.IcdGroupingRepository;
import com.emr.repository.IcdRepository;

@Service
public class IcdServiceImpl implements IcdService {

	@Autowired
	IcdRepository icdRepository;
	@Autowired
	IcdGroupingRepository icdGroupingRepository;

	@Override
	public Icd createIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		Optional<Icd> existingIcd = icdRepository.createIcd(icdReq.getIcdCode());
		if (existingIcd.isPresent()) {
			return existingIcd.get();
		} else {
			Icd icd = icdRepository.save(icdReq);
			icd.setRefId(icd.getId());
			icd.setOriginalRefId(icd.getId());

		}
		return icdRepository.save(icdReq);
	}
	

	@Override
	public List<Icd> getIcd() {
		// TODO Auto-generated method stub
		return icdRepository.findAllActiveRecords();
	}

	@Override
	public Icd getIcdCode(int id) {
		// TODO Auto-generated method stub
		return icdRepository.findById(id).get();
	}

	@Override
	public Icd updateIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		Optional<Icd> icdCode = icdRepository.findById(icdReq.getId());
		icdCode.ifPresent(icdcode -> {
			icdcode.setVersionState("InValid");
			icdcode.setRetired("Y");
			icdRepository.save(icdcode);
			icdReq.setRefId(icdcode.getId());
			icdReq.setOriginalRefId(icdcode.getOriginalRefId());
			icdReq.setVersionState("Valid");
			icdReq.setRetired("N");
			icdReq.setId(0);
			icdRepository.save(icdReq);
		});
		return icdReq;
	}

	@Override
	public void deleteIcd(int id) {
		// TODO Auto-generated method stub
		icdRepository.deleteById(id);
	}

//page pagination
	@Override
	public Page<Icd> getIcdPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return icdRepository.findAll(pageable);
	}
	// pagination search

	/*@Override
	public List<Icd> getIcdPaginationSearch(String icdcode, Pageable pageable) {
		// TODO Auto-generated method stub
		return icdRepository.getIcdPaginationSearch(icdcode, pageable).getContent();
	}*/

	@Override
	public Page<Icd> getIcdSearchSorting(String icdcode, Integer pageNumber, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable;
		if (sortBy.equals("Oldest First")) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
		} else {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		}

		return icdRepository.getIcdSearchSorting(icdcode, pageable);
	}


	@Override
	public Page<IcdGrouping> icdGroupingShortDescription(String codesearch, Pageable pageable) {
		// TODO Auto-generated method stub
		List<IcdGrouping> iCDList = icdGroupingRepository.icdGroupingShortDescription(codesearch);
		Sort sort = pageable.getSort();
		List<IcdGrouping> sortedItems = iCDList.stream().sorted((o1, o2) -> {
			for (Order order : sort) {
				int comparisonResult = compareItemsByProperty(o1, o2, order.getProperty());
				if (comparisonResult != 0) {
					return order.isAscending() ? comparisonResult : -comparisonResult;
				}
			}
			return 0;
		}).collect(Collectors.toList());
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int endIndex = Math.min(startIndex + pageable.getPageSize(), sortedItems.size());
		List<IcdGrouping> pageOfItems = sortedItems.subList(startIndex, endIndex);
		return new PageImpl<>(pageOfItems, pageable, sortedItems.size());
	}
	private int compareItemsByProperty(IcdGrouping o1, IcdGrouping o2, String property) {
		switch (property) {
		case"short_desc":
			return o1.getShortDesc().compareTo(o2.getShortDesc());
		case "icd_code":
			return o1.getIcdCode().compareTo(o2.getIcdCode());
		
		default:
			throw new IllegalArgumentException("Unknown sort property: " + property);
		}

	}

}
