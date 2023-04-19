package com.emr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allergy_new")
public class Allergy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="dam_concept_id")
	private String damConceptId;
	@Column(name="dam_concept_id_desc")
	private String damConceptIdDesc;
	@Column(name="dam_concept_id_type")
	private Integer damConceptIdType;
	@Column(name="dam_alrgn_grp_desc")
	private String damAlrgnGrpDesc;
	@Column(name="allergy_desc")
	private String allergyDesc;
	@Column(name="sno_med_code")
	private String snoMedCode;
	@Column(name="sno_med_concept")
	private String snoMedConcept;
	@Column(name="data_source")
	private String dataSource;
	@Column(name="version_state")
	private String versionState;
	@Column(name="status")
	private String status;
	@Column(name="modified_by")
	private String modifiedBy;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="modified_date")
	private Date modifiedDate;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="ref_id")
	private Integer refId;
	@Column(name="retired")
	private String retired;
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
	public String getDamConceptId() {
		return damConceptId;
	}
	public void setDamConceptId(String damConceptId) {
		this.damConceptId = damConceptId;
	}
	public String getDamConceptIdDesc() {
		return damConceptIdDesc;
	}
	public void setDamConceptIdDesc(String damConceptIdDesc) {
		this.damConceptIdDesc = damConceptIdDesc;
	}
	public Integer getDamConceptIdType() {
		return damConceptIdType;
	}
	public void setDamConceptIdType(Integer damConceptIdType) {
		this.damConceptIdType = damConceptIdType;
	}
	public String getDamAlrgnGrpDesc() {
		return damAlrgnGrpDesc;
	}
	public void setDamAlrgnGrpDesc(String damAlrgnGrpDesc) {
		this.damAlrgnGrpDesc = damAlrgnGrpDesc;
	}
	public String getAllergyDesc() {
		return allergyDesc;
	}
	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}
	public String getSnoMedCode() {
		return snoMedCode;
	}
	public void setSnoMedCode(String snoMedCode) {
		this.snoMedCode = snoMedCode;
	}
	public String getSnoMedConcept() {
		return snoMedConcept;
	}
	public void setSnoMedConcept(String snoMedConcept) {
		this.snoMedConcept = snoMedConcept;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public String getVersionState() {
		return versionState;
	}
	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getRetired() {
		return retired;
	}
	public void setRetired(String retired) {
		this.retired = retired;
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
