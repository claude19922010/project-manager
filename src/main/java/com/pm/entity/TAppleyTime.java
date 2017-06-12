package com.pm.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * TAppleyTime entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_appley_time", catalog = "pm")
public class TAppleyTime implements java.io.Serializable {

	// Fields

	private String id;
	private Date startTime;
	private Date endTime;

	// Constructors

	/** default constructor */
	public TAppleyTime() {
	}

	/** full constructor */
	public TAppleyTime(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID_", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "START_TIME_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "END_TIME_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}