package com.pm.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * TProject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project", catalog = "projectmanage")
public class TProject implements java.io.Serializable {

	// Fields

	private String id;
	private Date createDate;
	private String createUser;
	private Boolean invalid;
	private Date updateDate;
	private String updateUser;
	private Double budgetProject;
	private String businessRequirementsId;
	private String callUser;
	private String callUserPhone;
	private String declareMeans;
	private Date deliveryTime;
	private String deptName;
	private String externalParties;
	private String kjDeptFirstOpinion;
	private String kjDirectorApproval;
	private Integer level;
	private String name;
	private String otherId;
	private String projectBackground;
	private String projectContent;
	private String projectDept;
	private String projectTarget;
	private Date projectTime;
	private String projectType;
	private Integer state;
	private Integer tagHeadBank;
	private Integer tagProject;
	private String xqtcDept;
	private String xqtcDeptId;
	private String xtztjsfaId;
	private String xxhxmjysId;
	private String ywDirectorApproval;
	private String ywxqfxbgId;
	private String ywzgDept;
	private String ywzgDeptId;
	private String zgywhld;
	private String zgywhldUsername;
	private String createUserCname;
	private String updateUserCname;
	private Integer hldqz;
	private String qubie;

	// Property accessors
	@Id
	@Column(name = "ID_", unique = true, nullable = false, length = 60)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CREATE_DATE_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_USER_", length = 60)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "INVALID_")
	public Boolean getInvalid() {
		return this.invalid;
	}

	public void setInvalid(Boolean invalid) {
		this.invalid = invalid;
	}

	@Column(name = "UPDATE_DATE_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER_", length = 60)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "BUDGET_PROJECT_", precision = 22, scale = 0)
	public Double getBudgetProject() {
		return this.budgetProject;
	}

	public void setBudgetProject(Double budgetProject) {
		this.budgetProject = budgetProject;
	}

	@Column(name = "BUSINESS_REQUIREMENTS_ID_", length = 60)
	public String getBusinessRequirementsId() {
		return this.businessRequirementsId;
	}

	public void setBusinessRequirementsId(String businessRequirementsId) {
		this.businessRequirementsId = businessRequirementsId;
	}

	@Column(name = "CALL_USER_", length = 60)
	public String getCallUser() {
		return this.callUser;
	}

	public void setCallUser(String callUser) {
		this.callUser = callUser;
	}

	@Column(name = "CALL_USER_PHONE_", length = 60)
	public String getCallUserPhone() {
		return this.callUserPhone;
	}

	public void setCallUserPhone(String callUserPhone) {
		this.callUserPhone = callUserPhone;
	}

	@Column(name = "DECLARE_MEANS_", length = 120)
	public String getDeclareMeans() {
		return this.declareMeans;
	}

	public void setDeclareMeans(String declareMeans) {
		this.declareMeans = declareMeans;
	}

	@Column(name = "DELIVERY_TIME_", length = 19)
//	@Temporal(TemporalType.DATE)
	public Date getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Column(name = "DEPT_NAME_", length = 200)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "EXTERNAL_PARTIES_", length = 120)
	public String getExternalParties() {
		return this.externalParties;
	}

	public void setExternalParties(String externalParties) {
		this.externalParties = externalParties;
	}

	@Column(name = "KJ_DEPT_FIRST_OPINION_")
	public String getKjDeptFirstOpinion() {
		return this.kjDeptFirstOpinion;
	}

	public void setKjDeptFirstOpinion(String kjDeptFirstOpinion) {
		this.kjDeptFirstOpinion = kjDeptFirstOpinion;
	}

	@Column(name = "KJ_DIRECTOR_APPROVAL_")
	public String getKjDirectorApproval() {
		return this.kjDirectorApproval;
	}

	public void setKjDirectorApproval(String kjDirectorApproval) {
		this.kjDirectorApproval = kjDirectorApproval;
	}

	@Column(name = "LEVEL_")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "NAME_", length = 120)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "OTHER_ID_", length = 60)
	public String getOtherId() {
		return this.otherId;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

	@Column(name = "PROJECT_BACKGROUND_")
	public String getProjectBackground() {
		return this.projectBackground;
	}

	public void setProjectBackground(String projectBackground) {
		this.projectBackground = projectBackground;
	}

	@Column(name = "PROJECT_CONTENT_")
	public String getProjectContent() {
		return this.projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	@Column(name = "PROJECT_DEPT_", length = 120)
	public String getProjectDept() {
		return this.projectDept;
	}

	public void setProjectDept(String projectDept) {
		this.projectDept = projectDept;
	}

	@Column(name = "PROJECT_TARGET_")
	public String getProjectTarget() {
		return this.projectTarget;
	}

	public void setProjectTarget(String projectTarget) {
		this.projectTarget = projectTarget;
	}

	@Column(name = "PROJECT_TIME_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getProjectTime() {
		return this.projectTime;
	}

	public void setProjectTime(Date projectTime) {
		this.projectTime = projectTime;
	}

	@Column(name = "PROJECT_TYPE_", length = 120)
	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	@Column(name = "STATE_")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "TAG_HEAD_BANK_")
	public Integer getTagHeadBank() {
		return this.tagHeadBank;
	}

	public void setTagHeadBank(Integer tagHeadBank) {
		this.tagHeadBank = tagHeadBank;
	}

	@Column(name = "TAG_PROJECT_")
	public Integer getTagProject() {
		return this.tagProject;
	}

	public void setTagProject(Integer tagProject) {
		this.tagProject = tagProject;
	}

	@Column(name = "XQTC_DEPT_", length = 120)
	public String getXqtcDept() {
		return this.xqtcDept;
	}

	public void setXqtcDept(String xqtcDept) {
		this.xqtcDept = xqtcDept;
	}

	@Column(name = "XQTC_DEPT_ID_", length = 120)
	public String getXqtcDeptId() {
		return this.xqtcDeptId;
	}

	public void setXqtcDeptId(String xqtcDeptId) {
		this.xqtcDeptId = xqtcDeptId;
	}

	@Column(name = "XTZTJSFA_ID_", length = 60)
	public String getXtztjsfaId() {
		return this.xtztjsfaId;
	}

	public void setXtztjsfaId(String xtztjsfaId) {
		this.xtztjsfaId = xtztjsfaId;
	}

	@Column(name = "XXHXMJYS_ID_", length = 60)
	public String getXxhxmjysId() {
		return this.xxhxmjysId;
	}

	public void setXxhxmjysId(String xxhxmjysId) {
		this.xxhxmjysId = xxhxmjysId;
	}

	@Column(name = "YW_DIRECTOR_APPROVAL_")
	public String getYwDirectorApproval() {
		return this.ywDirectorApproval;
	}

	public void setYwDirectorApproval(String ywDirectorApproval) {
		this.ywDirectorApproval = ywDirectorApproval;
	}

	@Column(name = "YWXQFXBG_ID_", length = 60)
	public String getYwxqfxbgId() {
		return this.ywxqfxbgId;
	}

	public void setYwxqfxbgId(String ywxqfxbgId) {
		this.ywxqfxbgId = ywxqfxbgId;
	}

	@Column(name = "YWZG_DEPT_", length = 100)
	public String getYwzgDept() {
		return this.ywzgDept;
	}

	public void setYwzgDept(String ywzgDept) {
		this.ywzgDept = ywzgDept;
	}

	@Column(name = "YWZG_DEPT_ID_", length = 60)
	public String getYwzgDeptId() {
		return this.ywzgDeptId;
	}

	public void setYwzgDeptId(String ywzgDeptId) {
		this.ywzgDeptId = ywzgDeptId;
	}

	@Column(name = "ZGYWHLD_", length = 120)
	public String getZgywhld() {
		return this.zgywhld;
	}

	public void setZgywhld(String zgywhld) {
		this.zgywhld = zgywhld;
	}

	@Column(name = "ZGYWHLD_USERNAME_", length = 120)
	public String getZgywhldUsername() {
		return this.zgywhldUsername;
	}

	public void setZgywhldUsername(String zgywhldUsername) {
		this.zgywhldUsername = zgywhldUsername;
	}

	@Column(name = "CREATE_USER_CNAME_", length = 60)
	public String getCreateUserCname() {
		return this.createUserCname;
	}

	public void setCreateUserCname(String createUserCname) {
		this.createUserCname = createUserCname;
	}

	@Column(name = "UPDATE_USER_CNAME_", length = 60)
	public String getUpdateUserCname() {
		return this.updateUserCname;
	}

	public void setUpdateUserCname(String updateUserCname) {
		this.updateUserCname = updateUserCname;
	}

	@Column(name = "HLDQZ_")
	public Integer getHldqz() {
		return this.hldqz;
	}

	public void setHldqz(Integer hldqz) {
		this.hldqz = hldqz;
	}

	@Column(name = "QUBIE_")
	public String getQubie() {
		return this.qubie;
	}

	public void setQubie(String qubie) {
		this.qubie = qubie;
	}

}