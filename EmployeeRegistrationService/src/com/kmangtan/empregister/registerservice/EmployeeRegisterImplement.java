/*
 * Session Bean Implementation in which all methods defined in the Remote interface are implemented
 */
package com.kmangtan.empregister.registerservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.TypeConstraintException;

import com.kmangtan.empregister.entity.Contact;
import com.kmangtan.empregister.entity.Emp;

/**
 * @author kushal Implements all the methods defined in EmpRegRemoteInterface
 */
@Stateless
public class EmployeeRegisterImplement implements EmployeeRegisterRemoteInterface {
	@PersistenceContext(unitName = "Swe645University")
	private EntityManager entitymanager;

	public EmployeeRegisterImplement() {
	}

	
	/*
	 * Persists an Employee object in Employee relation 
		 *  Test cases: 
		 * Emp object is null 
		 * Emp object should have the required properties.
	 */
	public void insertEmployeeRecord(Emp emp) {

		if (emp == null)
			throw new NullPointerException();
		try {

			entitymanager.persist(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Checks if email is Unique or not  Test cases: checkEmail is null
		 *  Test cases: 
		 * checkEmail is null 
		 * checkEmail is not an instance of String
		 * checkEmail is not unique
		 * checkEmail is unique
	 */

	public int isEmailUnique(String checkEmail) {
		if (checkEmail == null)
			throw new NullPointerException();
		if (!(checkEmail instanceof String))
			throw new TypeConstraintException(
					"CheckEmail parameter is not an instance of the String class");
		int flag = 0;
		try {
			Query q = entitymanager.createQuery("select e.email from Emp e");
			@SuppressWarnings("unchecked")
			List<String> emaillist = (List<String>) q.getResultList();

			if (emaillist.size() > 0 && emaillist != null) {
				Iterator<String> iter = emaillist.iterator();
				while (iter.hasNext()) {

					String chk_email = iter.next();
					System.out.println("email is" + chk_email);
					if (chk_email.equalsIgnoreCase(checkEmail)) {
						flag = 0;
						return flag;
					}
				}
				flag = 1;
			} else {
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	/*
	 * Deletes an Employee Record from the Employee relation
		 *   Test cases: 
		 * id is null 
		 * id is not present in the Employee Relation
	 */
	public void deleteEmployeeRecord(String id) {
		if(id==null)
			throw new NullPointerException();
		int sample_id = Integer.parseInt(id);
		Emp e = entitymanager.find(Emp.class, sample_id);
		if(e==null )
			throw new NullPointerException();
		entitymanager.remove(e);
	}

	/*
	 * Gets a List of all the EmployeeRecords from the Employee relation
		 *   Test cases: 
		 *  employee Relation exists in Database
	 */
	@SuppressWarnings("unchecked")
	public List<Emp> getEmployeeList() {

		Query q = entitymanager.createQuery(" from Emp e order by e.lastname");

		return q.getResultList();

	}

	/*
	 * Gets an employeeRecord from the Employee Relation
		 *   Test cases: 
		 * id parameter is null 
		 * id parameter is not instance of String class
		 * Employee record is not null
	 */
	public Emp getEmployeeRecord(String id) {
		if(id==null)
			throw new NullPointerException();
		if (!(id instanceof String))
			throw new TypeConstraintException(
					"Id parameter is not an instance of the String class");
		int sample_id = Integer.parseInt(id);
		Emp e = entitymanager.find(Emp.class, sample_id);
		if (e==null)
			throw new NullPointerException();
		return e;
	}

	/*
	 * Searches for an Employee Record in the database 
		 *  Test cases
		 * parameter passed are null 
		 * parameter passed are not instance of String class
	 * 
	 */

	@SuppressWarnings("unchecked")
	public List<Emp> searchEmployeeRecord(String search_text,
			String search_using) {
		if((search_text==null)|| (search_using ==null))
			throw new NullPointerException();
		if((search_text==null)|| (search_using ==null))
			throw new TypeConstraintException("Search_Text,Search_using parameter are not an instance of String class");
		List<Emp> emp = new ArrayList<Emp>();
		if (search_using.equalsIgnoreCase("firstname")) {
			Query q = entitymanager
					.createQuery("from Emp E where E.firstname like :emp");
			q.setParameter("emp", search_text);
			emp = q.getResultList();
			return emp;
		}

		else if (search_using.equalsIgnoreCase("lastname")) {
			Query q = entitymanager
					.createQuery("from Emp E where E.lastname like :emp");
			q.setParameter("emp", search_text);
			emp = q.getResultList();
			return emp;
		}

		else {

			int dummy;
			dummy = Integer.parseInt(search_text);
			Query q = entitymanager
					.createQuery("from Contact C where C.phoneno like :ph");

			q.setParameter("ph", dummy);
			List<Contact> contactlist;

			contactlist = q.getResultList();

			for (Contact cont : contactlist) {
				Emp ee = new Emp();
				System.out.println("contactlistsize" + contactlist.size());
				System.out.println(cont.getEmp().getFirstname());
				ee = cont.getEmp();

				emp.add(ee);

			}

			return emp;
		}

	}

}
