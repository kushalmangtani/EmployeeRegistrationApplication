package com.kmangtan.empregister.registerform.bean;

import java.io.Serializable;

/**
 * @author kushal
 	*	A POJO class for Employee Registration Form
 */
public class EmpRegBean implements Serializable {
	private static final long serialVersionUID = 7071155702445525158L;

	public EmpRegBean() {
		
	}

	int id;
	String firstname;
	String middlename;
	String lastname;
	String email;
	String phoneno;
	String job;
	String location;
	String supervisor_reference;

	String office_address;
	int office_phone;

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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupervisor_reference() {
		return supervisor_reference;
	}

	public void setSupervisor_reference(String supervisor_reference) {
		this.supervisor_reference = supervisor_reference;
	}

	public String getOffice_address() {
		return office_address;
	}

	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}

	public int getOffice_phone() {
		return office_phone;
	}

	public void setOffice_phone(int office_phone) {
		this.office_phone = office_phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
