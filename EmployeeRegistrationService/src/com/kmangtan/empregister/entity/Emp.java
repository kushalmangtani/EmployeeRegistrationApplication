package com.kmangtan.empregister.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * Entity bean mapped with Emp table from the database
 */
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kushal
	 *POJO class
	 *Used for Object Relational mapping with emp relation
 */
@XmlRootElement
@Entity
@Table(name="emp")
public class Emp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1627027316306726820L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="middlename")
	private String middlename;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="job_id")
	
	private Job job;
	
	
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@OneToMany(mappedBy="emp",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	
	private Collection<Contact> contact;
	

 
	public Collection<Contact> getContact() {
		return contact;
	}

	public void setContact(Collection<Contact> contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	
	

}
