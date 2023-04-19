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


import com.emr.model.Cpt;
import com.emr.model.CptCategory1;
import com.emr.repository.CptCategoryRepository;
import com.emr.repository.CptRepository;

@Service
public class CptServiceImp implements CptService {
	
	@Autowired
	CptRepository cptRepository;
	@Autowired
	CptCategoryRepository cptCategoryRepository;

	@Override
	public Cpt createCpt(Cpt cptReq) {
		// TODO Auto-generated method stub
		Optional<Cpt> existingCode = cptRepository.getCptByVersionState(cptReq.getCode());
		if(existingCode.isPresent()) {
			return existingCode.get();
		}else {
			Cpt cpt = cptRepository.save(cptReq);
			cpt.setRefId(cpt.getId());
			cpt.setOriginalRefId(cpt.getId());
			
		}
		
		return cptRepository.save(cptReq);
	}

	@Override
	public List<Cpt> getCpt() {
		// TODO Auto-generated method stub
		return cptRepository.findActiveAll();
	}

	
	  /*@Override public Cpt updateCpt(int id, Cpt cptReq) { 
		  //TODO Auto-generated method stub
	 Cpt cpt = cptRepository.getById(id); cpt.setId(cptReq.getId());
	  cpt.setCode(cptReq.getCode()); cpt.setShortName(cptReq.getShortName());
	  cpt.setDescription(cptReq.getDescription());
	  cpt.setIsHCPCS(cptReq.getIsHCPCS());
	  cpt.setModifiedby(cptReq.getModifiedby());
	  cpt.setCreatedby(cptReq.getCreatedby());
	  cpt.setModifieddate(cptReq.getModifieddate());
	  cpt.setCreateddate(cptReq.getCreateddate()); return
	  cptRepository.save(cptReq); }*/
	 

	@Override
	public void deleteCptById(int id) {
		// TODO Auto-generated method stub
		cptRepository.deleteById(id);
	}

	@Override
	public Cpt getCptById(int id) {
		// TODO Auto-generated method stub
		return cptRepository.findById(id).get();
	}

	@Override
	public Page<Cpt> getCptPaginationById(Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.findAll(pageable);
	}

	
	/*  @Override 
	  public List<Cpt> getCptSearchById(String shortName, Pageable pageable) { 
		  // TODO Auto-generated method stub 
		  return cptRepository.getCptSearchById(shortName,pageable).getContent();
		   }*/
	 

	@Override
	public Cpt updateCpt(int id, Cpt cptReq) {
		// TODO Auto-generated method stub
		
		Optional<Cpt> existingCode = cptRepository.findById(cptReq.getId());
		existingCode.ifPresent(existingcode ->{
			// Updating Existing Code
			existingcode.setVersionState("InValid");
			existingcode.setRetired("Y");
			// existingCptCode.setRetired("Y");
			cptRepository.save(existingcode);
			// Inserting Modified Code As New One
			cptReq.setRefId(existingcode.getId());
			cptReq.setOriginalRefId(existingcode.getOriginalRefId());
			cptReq.setRetired("N");
			cptReq.setId(0);
			cptRepository.save(cptReq);
		});
		return cptReq;
	}

	/*@Override
	public List<CptCategory1> getCptCategorySearchCodeOrDesc(String codeOrdesc, Pageable pageable) {
		// TODO Auto-generated method stub
		List<CptCategory1> cptList = cptCategoryRepository.getCptCategorySearchCodeOrDesc(codeOrdesc);
		return ListUtils.getPage(cptList,pageable.getPageNumber()+1 ,pageable.getPageSize() );
	}*/

	
	//Without headers in cptcategory in search
	@Override
	public Page<CptCategory1> getCptCategory1CodeOrShortName(String codeOrShortName, Pageable pageable) {
		List<CptCategory1> cptList = cptCategoryRepository.getCptCategory1CodeOrShortName(codeOrShortName);
			// List<CptCategory> filteredCptList= ListUtils.getPage(cptList,
			// pageable.getPageNumber()+1, pageable.getPageSize());
			// return new PageImpl<CptCategory>(filteredCptList,pageable,cptList.size());
			Sort sort = pageable.getSort();
			List<CptCategory1> sortedItems = cptList.stream().sorted((o1, o2) -> {
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
			List<CptCategory1> pageOfItems = sortedItems.subList(startIndex, endIndex);
			return new PageImpl<>(pageOfItems, pageable, sortedItems.size());
		}
		private int compareItemsByProperty(CptCategory1 o1, CptCategory1 o2, String property) {
			switch (property) {
			case "short_name":
				return o1.getShortName().compareTo(o2.getShortName());
			case "code":
				return o1.getCode().compareTo(o2.getCode());
			// cptMajorCategory
			// ... add more cases for additional properties
			default:
				throw new IllegalArgumentException("Unknown sort property: " + property);
			}



		}




	/*@Override
	public List<Cpt> getCptSorting(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Direction.ASC,"Id");
		return cptRepository.findAll(pageable).getContent();
	}*/

	@Override
	public Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Integer pageSize, Integer pageNumber,String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable;
		if (sortBy.equals("Oldest First")) {
			pageable=PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.ASC, "id"));
		}else {
			pageable=PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC, "id"));
		}
		return cptRepository.getCptBycodeOrShortName(codeOrShortName,pageable);
	}

	
	

	
	
	
	
} 
	 


