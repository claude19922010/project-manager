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

@Entity
@Table(name = "t_project_time", catalog = "projectmanage")
public class TProjectTime {
	private String id;
	private int year;
	private Date startTimeDate;
	private Date endTimeDate;
	
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
	
	@Column(name = "YEAR_", length = 19)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Column(name = "START_TIME_DATE_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getStartTimeDate() {
		return this.startTimeDate;
	}

	public void setStartTimeDate(Date startTimeDate) {
		this.startTimeDate = startTimeDate;
	}
	
	@Column(name = "END_TIME_DATE_", length = 19)
	@Temporal(TemporalType.DATE)
	public Date getEndTimeDate() {
		return this.endTimeDate;
	}

	public void setEndTimeDate(Date endTimeDate) {
		this.endTimeDate = endTimeDate;
	}

}
