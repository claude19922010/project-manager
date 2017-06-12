package com.pm.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TProjectTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project_task", catalog = "projectmanage")
public class TProjectTask implements java.io.Serializable {

	// Fields

	private String id;
	private Timestamp createDate;
	private String createUser;
	private Boolean invalid;
	private Timestamp updateDate;
	private String updateUser;
	private String attachments;
	private Timestamp beginTime;
	private String content;
	private Timestamp endTime;
	private String name;
	private Timestamp overTime;
	private String person;
	private String personName;
	private Double progress;
	private String projectId;
	private Boolean projectState;
	private String createUserCname;
	private String updateUserCname;

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
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
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
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER_", length = 60)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "ATTACHMENTS_")
	public String getAttachments() {
		return this.attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	@Column(name = "BEGIN_TIME_", length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "CONTENT_")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "END_TIME_", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "NAME_", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "OVER_TIME_", length = 19)
	public Timestamp getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Timestamp overTime) {
		this.overTime = overTime;
	}

	@Column(name = "PERSON_", length = 120)
	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Column(name = "PERSON_NAME_", length = 120)
	public String getPersonName() {
		return this.personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "PROGRESS_", precision = 22, scale = 0)
	public Double getProgress() {
		return this.progress;
	}

	public void setProgress(Double progress) {
		this.progress = progress;
	}

	@Column(name = "PROJECT_ID_", length = 60)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "PROJECT_STATE_")
	public Boolean getProjectState() {
		return this.projectState;
	}

	public void setProjectState(Boolean projectState) {
		this.projectState = projectState;
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

}