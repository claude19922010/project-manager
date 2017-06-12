package com.pm.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TProjectMember entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_project_member", catalog = "projectmanage")
public class TProjectMember implements java.io.Serializable {

	// Fields

	private String id;
	private Timestamp createDate;
	private String createUser;
	private Boolean invalid;
	private Timestamp updateDate;
	private String updateUser;
	private String phone;
	private String projectId;
	private Integer projectRole;
	private String userName;
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

	@Column(name = "PHONE_", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "PROJECT_ID_", length = 60)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "PROJECT_ROLE_")
	public Integer getProjectRole() {
		return this.projectRole;
	}

	public void setProjectRole(Integer projectRole) {
		this.projectRole = projectRole;
	}

	@Column(name = "USER_NAME_", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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