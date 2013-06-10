package com.kmangtan.empregister.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author kushal
	 *POJO class
	 *Used for Object Relational mapping with contact_details relation
 */
@Entity
@Table(name="contact_details")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1086266930846918729L;




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int id;

	
	
	
	@Column(name="phoneno")
	private int phoneno;

	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="emp_id")
	@XmlTransient
	private Emp emp;
	

	@XmlTransient
	public Emp getEmp() {
		return emp;
	}


	public void setEmp(Emp emp) {
		this.emp = emp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	public int getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	
}
