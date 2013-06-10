/*
 * Remote Interface which is implemented by the session bean
 */
package com.kmangtan.empregister.registerservice;

import java.util.List;

import javax.ejb.Remote;

import com.kmangtan.empregister.entity.Emp;


@Remote
public interface EmployeeRegisterRemoteInterface {

	public void insertEmployeeRecord(Emp emp);

	public int isEmailUnique(String checkemail);

	public List<Emp> getEmployeeList();

	public void deleteEmployeeRecord(String id);

	public Emp getEmployeeRecord(String id);

	public List<Emp> searchEmployeeRecord(String search_text, String search_using);
	
	

}
