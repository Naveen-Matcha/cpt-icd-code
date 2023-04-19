package com.emr.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CptCategory1 {

	@Id
	private int id;
	private String code;
	private String shortName;
	private String description;
    private Boolean isHcpcs;
	private String modifiedBy;
	private String createdBy;
	private Date modifiedDate;
	private Date createdDate;
	private Integer refId;
	private Boolean retired;
	private String versionState;
	private Integer originalRefId;
	private String retiredReason;
	private Integer retiredOn;

	private String cptMajorCategory;
	private String cptMinorCategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getIsHcpcs() {
		return isHcpcs;
	}
	public void setIsHcpcs(Boolean isHcpcs) {
		this.isHcpcs = isHcpcs;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
	}
	public Boolean getRetired() {
		return retired;
	}
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	public Integer getOriginalRefId() {
		return originalRefId;
	}
	public void setOriginalRefId(Integer originalRefId) {
		this.originalRefId = originalRefId;
	}
	public String getRetiredReason() {
		return retiredReason;
	}
	public void setRetiredReason(String retiredReason) {
		this.retiredReason = retiredReason;
	}
	public Integer getRetiredOn() {
		return retiredOn;
	}
	public void setRetiredOn(Integer retiredOn) {
		this.retiredOn = retiredOn;
	}
	public String getCptMajorCategory() {
		return cptMajorCategory;
	}
	public void setCptMajorCategory(String cptMajorCategory) {
		this.cptMajorCategory = cptMajorCategory;
	}
	public String getCptMinorCategory() {
		return cptMinorCategory;
	}
	public void setCptMinorCategory(String cptMinorCategory) {
		this.cptMinorCategory = cptMinorCategory;
	}

	
	
}
