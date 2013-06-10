package com.kmangtan.empregister.entity;

/*
 * Entity bean mapped with job_details table from the database
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author kushal
	 *POJO class
	 *Used for Object Relational mapping with job relation
 */
@Entity
@Table(name="job_details")
public class Job implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1968887952834710008L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="location")
	private String location;
	
	@Column(name="supervisor")
	private String supervisor;
	
	@Column(name="office_address")
	private String office_address;
	
	@Column(name="office_phoneno")
	private int office_phoneno;
	
	@OneToOne(mappedBy="job",cascade={CascadeType.ALL})
	private Emp employee;
	
   @XmlTransient
	public Emp getEmployee() {
		return employee;
	}

	public void setEmployee(Emp employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	public int getOffice_phoneno() {
		return office_phoneno;
	}

	public void setOffice_phoneno(int office_phoneno) {
		this.office_phoneno = office_phoneno;
	}

}
