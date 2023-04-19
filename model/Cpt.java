package com.emr.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="cpt_short")
public class Cpt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="short_name")
	private String shortName;
	@Column(name="description")
	private  String description;
	@Column(name="is_hcpcs")
	private Boolean isHCPCS;
	@Column(name="modified_by")
	private String modifiedby;
	@Column(name="created_by")
	private String createdby;
	@UpdateTimestamp
	@Column(name="modified_date")
	private Date modifieddate;
	@CreationTimestamp
	@Column(name="created_date")
	private Date createddate;
	@Column(name="ref_id")
	private Integer refId;
	@Column(name="retired")
	private String retired;
	@Column(name="version_state")
	private String versionState="Valid";
	@Column(name="original_ref_id")
	private Integer originalRefId;
	@Column(name="retired_reason")
	private String retiredReason; 
	@Column(name="retired_on")
	private Integer retiredOn ;
	
	
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
	public Boolean getIsHCPCS() {
		return isHCPCS;
	}
	public void setIsHCPCS(Boolean isHCPCS) {
		this.isHCPCS = isHCPCS;
	}
	
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	
	public String getRetired() {
		return retired;
	}
	public void setRetired(String retired) {
		this.retired = retired;
	}
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	
	public Integer getRefId() {
		return refId;
	}
	public void setRefId(Integer refId) {
		this.refId = refId;
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
	
	
	
	

}
