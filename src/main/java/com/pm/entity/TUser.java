package com.pm.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "projectmanage")
public class TUser implements java.io.Serializable {

	// Fields

	private String username;
	private String address;
	private Boolean administrator;
	private Timestamp birthday;
	private String cname;
	private String companyId;
	private Timestamp createDate;
	private String email;
	private Boolean enabled;
	private String ename;
	private String identity;
	private Boolean male;
	private String mobile;
	private String password;
	private String salt;
	private String duty;
	private Integer fkId;
	private String fkSysName;

	// Property accessors
	@Id
	@Column(name = "USERNAME_", unique = true, nullable = false, length = 60)
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ADDRESS_", length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADMINISTRATOR_")
	public Boolean getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	@Column(name = "BIRTHDAY_", length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "CNAME_", nullable = false, length = 60)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "COMPANY_ID_", nullable = false, length = 60)
	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "CREATE_DATE_", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "EMAIL_", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ENABLED_")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "ENAME_", length = 60)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "IDENTITY_", length = 60)
	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column(name = "MALE_")
	public Boolean getMale() {
		return this.male;
	}

	public void setMale(Boolean male) {
		this.male = male;
	}

	@Column(name = "MOBILE_", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "PASSWORD_", nullable = false, length = 70)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "SALT_", length = 10)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "DUTY_", length = 120)
	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	@Column(name = "FK_ID_")
	public Integer getFkId() {
		return this.fkId;
	}

	public void setFkId(Integer fkId) {
		this.fkId = fkId;
	}

	@Column(name = "FK_SYS_NAME_", length = 120)
	public String getFkSysName() {
		return this.fkSysName;
	}

	public void setFkSysName(String fkSysName) {
		this.fkSysName = fkSysName;
	}

}