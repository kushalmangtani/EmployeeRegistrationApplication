/*
 * Controller class which controls the entire application flow.
 * 
 */
package com.kmangtan.empregister.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kmangtan.empregister.entity.Contact;
import com.kmangtan.empregister.entity.Emp;
import com.kmangtan.empregister.entity.Job;
import com.kmangtan.empregister.initialize.EjbInitialize;
import com.kmangtan.empregister.registerform.bean.EmpRegBean;
import com.kmangtan.empregister.registerservice.EmployeeRegisterRemoteInterface;
import com.kmangtan.empregister.searchform.bean.SearchBean;



/*
 * This is the Controller class .
 * 
 */

@Controller
@RequestMapping(value = "/EmpReg")
// request mapping for directing any request to the controller
public class EmpRegController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		if (binder.getTarget() instanceof EmpRegBean) {
			binder.setValidator(new EmpRegValidator());

		}
	}


	/** 
	 * @param action-Delete,View are the actions required for deleting employee record,viewing employee record  
	 * @param id-Id of the EmployeeRecord
	 * @return Employee Model and JSP View based on the action
	 	* All these actions are handled by the GET method
	 */
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView Emaillist(
			@RequestParam(value = "action", defaultValue = "loadAll") String action,
			@RequestParam(value = "id", defaultValue = "0") String id) {

		EmployeeRegisterRemoteInterface db = null;
		try {

			db = (EmployeeRegisterRemoteInterface) EjbInitialize.getejb("EmailRegEJB"); // Reference
			
		} catch (NamingException e) {
			e.getStackTrace();
		}

		SearchBean searchBean = new SearchBean();
		EmpRegBean empRegBean = new EmpRegBean();
		List<Emp> emplist = new ArrayList<Emp>();

		ModelAndView mav = new ModelAndView();

		/*
		 * Deleting request from JSP gets mapped here
		 */
		if (action.equalsIgnoreCase("delete")) {

			db.deleteEmployeeRecord(id);
		}
		/*
		 * View Info request from JSP gets mapped here
		 */

		if (action.equalsIgnoreCase("view")) {
			System.out.println("In Controller view");
			Emp employee = new Emp();
			employee = db.getEmployeeRecord(id);

			mav.addObject("empRegBean", employee);
			mav.setViewName("EmployeeView");
			return mav;
		}

		emplist = db.getEmployeeList();

		mav.setViewName("EmployeeList");
		mav.addObject("empRegBean", empRegBean);
		mav.addObject("emplist", emplist);

		if (action.equalsIgnoreCase("change")) {
			mav.setViewName("EmployeeInfo");

		} else {
			mav.setViewName("EmployeeList");

		}

		/*
		 * Search request from JSP gets mapped here Note: only search page gets
		 * mapped here and Search Result page gets handled here
		 */

		if (action.equalsIgnoreCase("search")) {
			mav.addObject("searchBean", searchBean);
			mav.setViewName("Search");
		}

		return mav;
	}


	/**
	 * @param empRegBean:Employee Bean passed from the EmployeeInfo viewName 
	 * @param result: Has the result of validation errors
	 * @return a String containing the ViewName to be mapped after the execution of this method
	 	* Insert data into the Employee Record is handled by POST	
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String SaveEmployeeInfo(@Valid EmpRegBean empRegBean,
			BindingResult result, Model model) {

		String viewname = null;
		try {
			List<Emp> emplist = new ArrayList<Emp>();
			EmployeeRegisterRemoteInterface db = null;
			try {
				db = (EmployeeRegisterRemoteInterface) EjbInitialize.getejb("EmailRegEJB"); // Reference
																					// to
																					// an
																					// EJb
																					// is
																					// made
				
			} catch (NamingException e) {
				e.getStackTrace();
			}
			if (!result.hasErrors())

			{

				Emp employee = new Emp();

				Job job = new Job();

				Collection<Contact> cont = new ArrayList<Contact>();

				// setting personal info from Emp Entity bean into Employee
				// object
				employee.setFirstname(empRegBean.getFirstname());
				employee.setMiddlename(empRegBean.getMiddlename());
				employee.setLastname(empRegBean.getLastname());
				employee.setEmail(empRegBean.getEmail());

				// setting job info from Job Entity bean into Employee object

				job.setLocation(empRegBean.getLocation());
				job.setOffice_address(empRegBean.getOffice_address());
				job.setOffice_phoneno(empRegBean.getOffice_phone());
				job.setSupervisor(empRegBean.getSupervisor_reference());
				job.setTitle(empRegBean.getJob());

				employee.setJob(job);

				// setting Contact info from Contact Entity bean into Employee
				// object

				String phone = empRegBean.getPhoneno();
				String[] nos = phone.split(",");

				for (int i = 0; i < nos.length; i++) {
					Contact contact = new Contact();
					int k = Integer.parseInt(nos[i]);
					System.out.println("k is" + k);

					contact.setPhoneno(k);

					contact.setEmp(employee);
					cont.add(contact);

				}

				System.out.println("ISZE IS" + cont.size());
				employee.setContact(cont);
				Iterator<Contact> iter = employee.getContact().iterator();
				while (iter.hasNext()) {
					Contact cont11 = iter.next();
					System.out.println("phone no" + cont11.getPhoneno());

				}

				// Inserting Employee model attribute

				db.insertEmployeeRecord(employee);

				model.addAttribute("empRegBean", employee);
				viewname = "EmployeeList";

			}

			else {
				model.addAllAttributes(result.getAllErrors());
				model.addAttribute("empRegBean", empRegBean);
				viewname = "EmployeeInfo";
			}

			// Retrieving List details
			emplist = db.getEmployeeList();

			model.addAttribute("emplist", emplist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewname;

	}

}
